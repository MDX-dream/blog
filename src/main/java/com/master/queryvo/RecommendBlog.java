package com.master.queryvo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 推荐博客数据实体类
 * </p>
 *
 * @author MDX
 * @since 2023/4/12 10:32
 */
@Data
@NoArgsConstructor
public class RecommendBlog {
    private Long id;
    private String title;
    private String firstPicture;
    private boolean recommend;
}
