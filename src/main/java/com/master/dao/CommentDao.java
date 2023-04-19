package com.master.dao;

import com.master.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 评论数据表 Mapper 接口
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Mapper
@Repository
public interface CommentDao {

    // 查询父级评论
    List<Comment> findByBlogIdParentIdNull(@Param("blogId") Long blogId, @Param("blogParentId") Long blogParentId);

    // 查询一级回复
    List<Comment> findByBlogIdParentIdNotNull(@Param("blogId") Long blogId, @Param("id") Long id);

    // 查询二级回复
    List<Comment> findByBlogIdAndReplayId(@Param("blogId") Long blogId, @Param("childId") Long childId);

    // 添加一个评论
    int saveComment(Comment comment);

    // 删除评论
    void deleteComment(Long id);

    // 根据父评论id查询留言信息
    Comment getEmailByParentId(Long parentId);
}
