package com.master.queryvo;

import com.master.entity.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <p>
 * 查询博客列表
 * </p>
 *
 * @author MDX
 * @since 2023/4/12 10:16
 */

@Data
@NoArgsConstructor
public class BlogQuery {
    private Long id;
    private String title;
    private Date createTime;
    private Date updateTime;
    private Boolean recommend;
    private Boolean published;
    private Long typeId;
    private Type type;
}
