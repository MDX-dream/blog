package com.master.queryvo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 搜索博客管理列表
 * </p>
 *
 * @author MDX
 * @since 2023/4/12 10:34
 */
@Data
@NoArgsConstructor
public class SearchBlog {
    private String title;
    private Long typeId;
}
