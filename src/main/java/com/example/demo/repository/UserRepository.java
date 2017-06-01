package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by tianxianglan on 2017/5/30.
 */
@Component
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByName(String name);
}
