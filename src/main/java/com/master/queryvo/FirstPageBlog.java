package com.master.queryvo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 * 首页博客信息实体类
 * </p>
 *
 * @author MDX
 * @since 2023/4/12 10:30
 */
@Data
@NoArgsConstructor
public class FirstPageBlog {
    //博客信息
    private Long id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Integer commentCount;
    private Date createTime;
    private Date updateTime;
    private String description;

    //分类名称
    private String typeName;

    //用户名
    private String nickname;
    //用户头像
    private String avatar;
}
