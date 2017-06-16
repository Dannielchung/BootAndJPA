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

    /*
    * @description:更新用户id去更新用户名
    * */
    public void updateInfo(int userId, String userName);
}
