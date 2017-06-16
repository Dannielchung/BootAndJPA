package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by tianxianglan on 2017/5/30.
 */
@Component
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findUserByName(String name);

    @Transactional
    @Modifying
    @Query("update User user set user.name = ?2 where user.id = ?1")
    public void updateInfo(int userId, String userName);
}
