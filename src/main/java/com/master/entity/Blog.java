package com.master.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 博客数据表
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Blog {


    private Long id;

    /**
     * 赞赏开启
     */
    private Boolean appreciation;

    /**
     * 评论开启
     */
    private Boolean commentabled;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 首图
     */
    private String firstPicture;

    private String flag;

    /**
     * 是否发布
     */
    private Boolean published;

    /**
     * 标记
     */
    private Boolean recommend;

    /**
     * 版权开启
     */
    private Boolean shareStatement;

    /**
     * 标题
     */
    private String title;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * []
     */
    private Integer views;

    /**
     * [类型id]
     */
    private Long typeId;

    /**
     * [用户id]
     */
    private Long userId;

    /**
     * 描述
     */
    private String description;

    /**
     * 浏览次数
     */
    private Integer commentCount;


    private Type type;
    private User user;
    private List<Comment> comments = new ArrayList<>();
}
