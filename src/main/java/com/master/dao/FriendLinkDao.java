package com.master.dao;

import com.master.entity.FriendLink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 朋友数据表 Mapper 接口
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Mapper
@Repository
public interface FriendLinkDao {

    //查询朋友管理列表
    List<FriendLink> listFriendLink();

    //新增朋友
    int saveFriendLink(FriendLink friendLink);

    //根据网址查询朋友
    FriendLink getFriendLinkByBlogaddress(String blogaddress);

    //根据id查询朋友
    FriendLink getFriendLink(Long id);

    //编辑修改朋友
    int updateFriendLink(FriendLink friendLink);

    //删除朋友
    void deleteFriendLink(Long id);
}
