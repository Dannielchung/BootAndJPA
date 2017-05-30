package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianxianglan on 2017/5/30.
 */
@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public User search(String name){
        return userRepository.findByName(name);
    }

    public void save(User user){
        userRepository.save(user);
    }
}
