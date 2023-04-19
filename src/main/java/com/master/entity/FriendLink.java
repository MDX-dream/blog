package com.master.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 朋友数据表
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class FriendLink {


    private Long id;

    /**
     * 网址
     */
    private String blogaddress;

    /**
     * 名称
     */
    private String blogname;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 图片地址
     */
    private String pictureaddress;


}
