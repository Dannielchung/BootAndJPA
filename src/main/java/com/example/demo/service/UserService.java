package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tianxianglan on 2017/5/30.
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User search(String name){
        User user =  userRepository.findUserByName(name);
        return user;
    }

    public void save(User user){
        userRepository.save(user);
    }
}
