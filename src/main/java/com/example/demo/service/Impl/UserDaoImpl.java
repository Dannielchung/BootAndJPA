package com.example.demo.service.Impl;

import com.example.demo.common.Response;
import com.example.demo.common.Status;
import com.example.demo.entity.User;
import com.example.demo.exception.InvalidException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tianxianglan on 2017/6/16.
 */
@Service
public class UserDaoImpl {
    @Autowired
    UserRepository userRepository;

    public User findByName(String name){
        User user =  userRepository.findUserByName(name);
        return user;
    }

    public Response updateInfo(User user){
        if (user != null){
            try {
                userRepository.updateInfo(user.getId(), user.getName());
            }catch (Exception e){
                throw new InvalidException(1000, "invalid action");
            }
            return new Response(Status.SUCCESS);
        }else
            return new Response(Status.ERROR);
    }
}
