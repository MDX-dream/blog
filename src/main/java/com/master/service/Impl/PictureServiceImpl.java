package com.master.service.Impl;

import com.master.dao.PictureDao;
import com.master.entity.Picture;
import com.master.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 照片墙业务层接口实现类
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    @Cacheable(value = "pictureList", key = "'picture'")      // redis缓存
    public List<Picture> listPicture() {

        return pictureDao.listPicture();
    }

    @Override
    public int savePicture(Picture picture) {
        return pictureDao.savePicture(picture);
    }

    @Override
    public Picture getPicture(Long id) {
        return pictureDao.getPicture(id);
    }

    @Override
    public int updatePicture(Picture picture) {
        // int result = pictureDao.updatePicture(picture);
        // if(result != 0) {
        //     String key = "picture_"+picture.getId();
        //     boolean haskey = redisTemplate.hasKey(key);
        //     if(haskey){
        //         redisTemplate.delete(key);
        //         System.out.println("删除缓存中的key-----------> " + key);
        //     }
        //     // 将更新后的数据加入缓存
        //     if(picture != null){
        //
        //     }
        //
        // }
        return pictureDao.updatePicture(picture);
    }

    @Override
    @Transactional
    public int deletePicture(Long id) {
//        int result = pictureDao.deletePicture(id);
//        // String key = "picture_"+id;
//        // if(result!=0){
//        //     boolean hasKey = redisTemplate.hasKey(key);
//        //     if(hasKey){
//        //         redisTemplate.delete(key);
//        //         System.out.println("删除了缓存中的key:"+key);
//        //     }
//        // }
//        return result;
        return pictureDao.deletePicture(id);
    }
}
