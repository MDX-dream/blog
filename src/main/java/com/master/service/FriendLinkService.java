package com.master.service;

import com.master.entity.FriendLink;

import java.util.List;

/**
 * <p>
 * 朋友业务层接口
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
public interface FriendLinkService {

    //查询所有朋友
    List<FriendLink> listFriendLink();

    //朋友新增
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
