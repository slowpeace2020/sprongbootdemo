package com.myspringboot.service;

import com.myspringboot.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void queryById() {
        User user = userService.queryById(8L);
        System.out.println(user);
    }

    @Test
    public void save() {
        User user = new User();
        user.setAge(30);
        user.setName("test");
        user.setUserName("test");
        user.setPassword("test");
        user.setCreated(new Date());
        user.setUpdated(new Date());
        userService.save(user);
        System.out.println(user);
    }
}