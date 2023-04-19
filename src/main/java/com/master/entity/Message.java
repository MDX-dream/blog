package com.master.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 留言数据表
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Message {


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
     * 父评论id
     */
    private Long parentMessageId;

    /**
     * 管理员
     */
    private Boolean adminMessage;

    /**
     * 父邮箱
     */
    private String parentEmail;

    //回复留言
    private List<Message> replyMessages = new ArrayList<>();
    private Message parentMessage;
    private String parentNickname;

}
