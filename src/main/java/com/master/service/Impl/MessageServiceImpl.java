package com.master.service.Impl;

import com.master.dao.MessageDao;
import com.master.entity.Message;
import com.master.service.MessageService;
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
 * 留言业务层接口实现类
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    // 自动导入Java邮件发送实现类
    @Autowired
    private JavaMailSender javaMailSender;

    //存放迭代找出的所有子代的集合
    private List<Message> tempReplys = new ArrayList<>();

    /**
     * @param
     * @return 留言消息
     * @Description 查询留言
     */
    @Override
    // @Cacheable(value = "messageList",key = "'message'")
    public List<Message> listMessage() {
        //查询出父节点
        List<Message> messages = messageDao.findByParentIdNull(Long.parseLong("-1"));
        for (Message message : messages) {
            Long id = message.getId();
            String parentNickname1 = message.getNickname();
            List<Message> childMessages = messageDao.findByParentIdNotNull(id);

            //查询出子留言
            combineChildren(childMessages, parentNickname1);
            message.setReplyMessages(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return messages;
    }

    /**
     * @param childMessages：所有子留言
     * @param parentNickname1：父留言的姓名
     * @Description 查询出子留言
     */
    private void combineChildren(List<Message> childMessages, String parentNickname1) {
        //判断是否有一级子回复
        if (childMessages.size() > 0) {
            //循环找出子留言的id
            for (Message childMessage : childMessages) {
                String parentNickname = childMessage.getNickname();
                childMessage.setParentNickname(parentNickname1);
                tempReplys.add(childMessage);
                Long childId = childMessage.getId();
                //查询二级以及所有子集回复
                recursively(childId, parentNickname);
            }
        }
    }

    /**
     * @param childId：子留言的id
     * @param parentNickname1：子留言的姓名
     * @return
     * @Description 循环迭代找出子集回复
     */
    private void recursively(Long childId, String parentNickname1) {
        //根据子一级留言的id找到子二级留言
        List<Message> replayMessages = messageDao.findByReplayId(childId);

        if (replayMessages.size() > 0) {
            for (Message replayMessage : replayMessages) {
                String parentNickname = replayMessage.getNickname();
                replayMessage.setParentNickname(parentNickname1);
                Long replayId = replayMessage.getId();
                tempReplys.add(replayMessage);
                //循环迭代找出子集回复
                recursively(replayId, parentNickname);
            }
        }
    }

    @Override
    //存储留言信息
    public int saveMessage(Message message, Message parentMessage) {
        message.setCreateTime(new Date());

        // 判断是否有父评论，有的话就发送邮件
//        if (!StringUtils.isEmpty(parentMessage)) {
        if (!ObjectUtils.isEmpty(parentMessage)) {
            String parentNickname = parentMessage.getNickname();
            String nickName = message.getNickname();
            String comtent = "亲爱的" + parentNickname + "，您在【迟梦君-->迟梦阁】的评论收到了来自" + nickName + "的回复！内容如下：" + "\r\n" + "\r\n" + message.getContent();
            String parentEmail = parentMessage.getEmail();

            // 发送邮件
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setSubject("迟梦君-->迟梦阁评论回复");  //主题
            simpleMailMessage.setText(comtent);   //内容
            simpleMailMessage.setTo(parentEmail); //接收者的邮箱
            simpleMailMessage.setFrom("dongaisun21@163.com");//发送者邮箱
            javaMailSender.send(simpleMailMessage);
        }

        return messageDao.saveMessage(message);
    }

    //    删除留言
    @Override
    public void deleteMessage(Long id) {
        messageDao.deleteMessage(id);
    }

    @Override
    public Message getEmailByParentId(Long parentId) {
        return messageDao.getEmailByParentId(parentId);
    }
}
