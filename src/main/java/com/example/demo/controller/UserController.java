package com.example.demo.controller;

import com.example.demo.annotation.PermissionEnum;
import com.example.demo.annotation.SelfPermission;
import com.example.demo.common.Response;
import com.example.demo.entity.User;
import com.example.demo.service.Impl.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianxianglan on 2017/5/30.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserDaoImpl userDaoImpl;


    @PostMapping(value = "/test")
    @SelfPermission(value = {PermissionEnum.ADMIN, PermissionEnum.COMMON_USER})
    public Response test() {
        User findUser = userDaoImpl.findByName("leo");
        return userDaoImpl.updateInfo(findUser);
    }

}
