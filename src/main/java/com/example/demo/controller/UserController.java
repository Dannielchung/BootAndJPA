package com.example.demo.controller;

import com.example.demo.annotation.PermissionEnum;
import com.example.demo.annotation.SelfPermitition;
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
    @SelfPermitition(value = {PermissionEnum.ADMIN, PermissionEnum.COMMON_USER})
    public void test(String token){
        User findUser = userService.search("leo");
        String groupName = findUser.getGroup().getName();
        System.out.println(groupName);
    }

    @PostMapping(value = "/testNULL")

    public void yy(){
        System.out.println("test annotation is null");
    }
}
