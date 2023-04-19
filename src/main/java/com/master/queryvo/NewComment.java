package com.master.queryvo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 最新评论实体类
 * </p>
 *
 * @author MDX
 * @since 2023/4/12 10:31
 */
@Data
@NoArgsConstructor
public class NewComment {
    private Long id;
    private Long blogId;
    private String title;
    private String content;
}
