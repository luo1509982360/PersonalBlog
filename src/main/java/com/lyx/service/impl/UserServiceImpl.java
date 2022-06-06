package com.lyx.service.impl;

import com.lyx.bean.User;
import com.lyx.dao.UserMapper;
import com.lyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author The setting sun
 * @version 1.0
 * @title: UserServiceImpl
 * @description: TODO
 * @date 2022/5/13 17:32
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        User user = userMapper.findByUsernameAndPassword(username, password);

        return user;
    }
}
