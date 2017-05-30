package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * Created by tianxianglan on 2017/5/30.
 */
@Component
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByName(String name);
}
