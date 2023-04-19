package com.master.queryvo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 * 博客详情实体类
 * </p>
 *
 * @author MDX
 * @since 2023/4/12 10:29
 */
@Data
@NoArgsConstructor
public class DetailedBlog {
    //博客信息
    private Long id;
    private String firstPicture;
    private String flag;
    private String title;
    private String content;
    private Integer views;
    private Integer commentCount;
    private Date updateTime;
    private boolean commentabled;
    private boolean shareStatement;
    private boolean appreciation;
    private String nickname;
    private String avatar;

    //分类名称
    private String typeName;
}
