package com.master.service.Impl;

import com.master.dao.BlogDao;
import com.master.dao.CommentDao;
import com.master.entity.Comment;
import com.master.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 博客评论业务层接口实现类
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Service
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentDao commentDao;

    @Autowired
    private BlogDao blogDao;

    // 自动导入Java邮件发送实现类
    @Autowired
    private JavaMailSender javaMailSender;

    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();

    /**
     * @Description 查询评论
     * @param blogId 博客id
     * @return 评论消息
     */
    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        //查询出父节点
        List<Comment> comments = commentDao.findByBlogIdParentIdNull(blogId, Long.parseLong("-1"));
        for (Comment comment : comments) {
            Long id = comment.getId();
            String parentNickname1 = comment.getNickname();
            List<Comment> childComments = commentDao.findByBlogIdParentIdNotNull(blogId, id);
            //查询出子评论
            combineChildren(blogId, childComments, parentNickname1);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return comments;
    }

    /**
     * @param childComments：所有子评论
     * @param parentNickname1：父评论姓名
     * @Description 查询出子评论
     */
    private void combineChildren(Long blogId, List<Comment> childComments, String parentNickname1) {
        //判断是否有一级子评论
        if (childComments.size() > 0) {
            //循环找出子评论的id
            for (Comment childComment : childComments) {
                String parentNickname = childComment.getNickname();
                childComment.setParentNickname(parentNickname1);
                tempReplys.add(childComment);
                Long childId = childComment.getId();
                //查询出子二级评论
                recursively(blogId, childId, parentNickname);
            }
        }
    }

    /**
     * @param childId         子评论id
     * @param parentNickname1 子评论姓名
     * @Description 循环迭代找出子集回复
     * 10:44 2020/6/23
     */
    private void recursively(Long blogId, Long childId, String parentNickname1) {
        //根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentDao.findByBlogIdAndReplayId(blogId, childId);

        if (replayComments.size() > 0) {
            for (Comment replayComment : replayComments) {
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                recursively(blogId, replayId, parentNickname);
            }
        }
    }


    //新增评论
    @Override
    public int saveComment(Comment comment, Comment parentComment) {
        comment.setCreateTime(new Date());
        int comments = commentDao.saveComment(comment);
        //文章评论计数
        blogDao.getCommentCountById(comment.getBlogId());

        // 判断是否有父评论，有的话就发送邮件
//        if (!StringUtils.isEmpty(parentComment)) {
        if (!ObjectUtils.isEmpty(parentComment)) {
            String parentNickname = parentComment.getNickname();
            String nickName = comment.getNickname();
            String comtent = "亲爱的" + parentNickname + "，您在【迟梦君-->迟梦阁】的评论收到了来自" + nickName + "的回复！内容如下：" + "\r\n" + "\r\n" + comment.getContent();
            String parentEmail = parentComment.getEmail();

            // 发送邮件
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject("迟梦君-->迟梦阁评论回复");  //主题
            simpleMailMessage.setText(comtent);   //内容
            simpleMailMessage.setTo(parentEmail); //收件人
            simpleMailMessage.setFrom("dongaisun21@163.com");//发件人
            javaMailSender.send(simpleMailMessage);
        }

        return comments;
    }

    //删除评论
    @Override
    public void deleteComment(Comment comment, Long id) {
        commentDao.deleteComment(id);
        blogDao.getCommentCountById(comment.getBlogId());
    }

    @Override
    public Comment getEmailByParentId(Long parentId) {
        return commentDao.getEmailByParentId(parentId);
    }
}
