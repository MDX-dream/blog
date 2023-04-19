package com.master.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 资源
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Resources {


    private Long id;

    private String resourceName;

    private String resourceAddress;

    private String firstType;

    private String secondType;

    private String pictureAddress;

    private String resourceDescription;

    private Date createTime;

    private Integer sort;

    private Boolean published;

    public Boolean isPublished() {
        return published;
    }


}
