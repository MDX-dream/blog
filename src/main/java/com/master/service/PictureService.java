package com.master.service;

import com.master.entity.Picture;

import java.util.List;

/**
 * <p>
 * 照片墙业务层接口
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
public interface PictureService {

    //查询照片
    List<Picture> listPicture();

    //添加图片
    int savePicture(Picture picture);

    //根据id查询照片
    Picture getPicture(Long id);

    //编辑修改相册
    int updatePicture(Picture picture);

    //删除照片
    int deletePicture(Long id);

}
