package com.example.demo.service.Impl;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tianxianglan on 2017/6/16.
 */
public class UserDaoImpl {
    @Autowired
    UserRepository userRepository;

    public User findByName(String name){
        User user =  userRepository.findUserByName(name);
        return user;
    }
}
