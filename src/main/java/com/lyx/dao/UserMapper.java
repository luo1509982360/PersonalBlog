package com.lyx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyx.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author The setting sun
 * @version 1.0
 * @title: UserDao
 * @description: TODO
 * @date 2022/5/13 17:34
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User findByUsernameAndPassword(String username, String password);
}
