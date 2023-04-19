package com.master.queryvo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 * 编辑修改文章实体类
 * </p>
 *
 * @author MDX
 * @since 2023/4/12 10:34
 */
@Data
@NoArgsConstructor
public class ShowBlog {
    private Long id;
    private String flag;
    private String title;
    private String content;
    private Long typeId;
    private String firstPicture;
    private String description;
    private boolean recommend;
    private boolean published;
    private boolean shareStatement;
    private boolean appreciation;
    private boolean commentabled;
    private Date updateTime;
}
