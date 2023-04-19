package com.master.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 分类数据表
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Type {


    private Long id;

    /**
     * 分类名称
     */
    private String name;

    private List<Blog> blogs = new ArrayList<>();


}
