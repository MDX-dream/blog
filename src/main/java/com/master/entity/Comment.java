package com.master.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 评论数据表
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Comment {


    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 博客id
     */
    private Long blogId;

    /**
     * 父评论id
     */
    private Long parentCommentId;

    /**
     * 管理员
     */
    private Boolean adminComment;

    //回复评论
    private List<Comment> replyComments = new ArrayList<>();
    private Comment parentComment;
    private String parentNickname;


}
