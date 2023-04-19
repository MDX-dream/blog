package com.master.service;

import com.master.entity.User;

/**
 * <p>
 * 用户业务层接口
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
public interface UserService {

    //核对用户名和密码
    User checkUser(String username, String password);
}
