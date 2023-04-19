package com.master.service;

import com.master.entity.Comment;

import java.util.List;

/**
 * <p>
 * 评论业务层接口
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
public interface CommentService {

    //根据博客id查询评论信息
    List<Comment> listCommentByBlogId(Long blogId);

    //添加保存评论
    int saveComment(Comment comment, Comment parentComment);

    //删除评论
    void deleteComment(Comment comment, Long id);

    // 根据父评论id查询留言信息
    Comment getEmailByParentId(Long parentId);
}
