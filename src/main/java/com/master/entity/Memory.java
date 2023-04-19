package com.master.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 记忆
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Memory {

    private static final long serialVersionUID = 1L;


    private Long id;

    private Date createTime;

    private String pictureAddress;

    private String memory;


}
