package com.master.dao;

import com.master.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户数据表 Mapper 接口
 * </p>
 *
 * @author mybatis-plus
 * @since 2023-04-11
 */
@Mapper
@Repository
public interface UserDao {

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
