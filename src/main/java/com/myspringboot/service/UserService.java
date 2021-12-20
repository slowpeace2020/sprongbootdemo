package com.myspringboot.service;

import com.myspringboot.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User queryById(Long id){
        return new User();
    }

    public void save(User user){
        System.out.println("save user.....");
    }

}
