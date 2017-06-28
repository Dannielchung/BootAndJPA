package com.example.demo.serviceTest;

import com.example.demo.entity.User;
import com.example.demo.service.Impl.UserDaoImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cvter on 2017/6/1.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserDaoImpl userDaoImpl;

    @Test
    public void searchTest(){
        User findUser = userDaoImpl.findByName("leo");
        Assert.assertEquals(1, findUser.getGroupId());
    }
}
