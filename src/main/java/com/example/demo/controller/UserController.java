package com.example.demo.controller;

import com.example.demo.annotation.PermissionEnum;
import com.example.demo.annotation.SelfPermission;
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
    @SelfPermission(value = {PermissionEnum.ADMIN, PermissionEnum.COMMON_USER})
    public void test(String token) {
        User findUser = userService.findByName("leo");
        String groupName = findUser.getGroup().getName();
        System.out.println(groupName);
    }

}
