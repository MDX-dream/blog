package com.master.service.Impl;

import com.master.dao.UserDao;
import com.master.entity.User;
import com.master.service.UserService;
import com.master.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户业务层接口实现类
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * @param username:用户名；password:密码
     * @return 返回用户对象
     * @Description: 21:25 2020/5/27
     */
    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
