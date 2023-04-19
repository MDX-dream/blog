package com.master.dao;

import com.master.entity.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 相册数据表 Mapper 接口
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Mapper
@Repository
public interface PictureDao {

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
