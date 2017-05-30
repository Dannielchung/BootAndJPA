package com.example.demo;

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
        String name = "lan";
        User findUser = userService.search(name);
        System.out.println(findUser.getName()+ findUser.getId());

        User user = new User();
        user.setId(2);
        user.setName("tianxiang");
        userService.save(user);
    }
}
