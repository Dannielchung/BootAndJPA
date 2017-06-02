package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianxianglan on 2017/5/30.
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/test")
    public void test(){
        /*User user = new User();
        user.setId(2);
        user.setName("tianxiang");
        userService.save(user);*/

        User findUser = userService.search("leo");
        String groupName = findUser.getGroup().getName();
        System.out.println(groupName);
    }
}
