package com.master.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 相册数据表
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Picture {


    private Long id;

    /**
     * 图片地址
     */
    private String pictureaddress;

    /**
     * 图片描述
     */
    private String picturedescription;

    /**
     * 图片名称
     */
    private String picturename;

    /**
     * 时间地点
     */
    private String picturetime;


}
