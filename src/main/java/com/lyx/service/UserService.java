package com.lyx.service;

import com.lyx.bean.User;
import org.springframework.stereotype.Service;

/**
 * @author The setting sun
 * @version 1.0
 * @title: UserService
 * @description: TODO
 * @date 2022/5/13 17:31
 */
@Service
public interface UserService {
   User checkUser(String username, String password);
}
