package com.example.demo.service;

import com.example.demo.entity.User;

/**
 * Created by tianxianglan on 2017/6/16.
 */
public interface UserDao {
    /*
    * @description:根据用户名去搜索用户
    * */
    public User findByName(String name);
}
