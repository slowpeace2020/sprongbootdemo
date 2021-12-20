package com.myspringboot.service;

import com.myspringboot.mapper.UserMapper;
import com.myspringboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //根据ID查询
    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional
    public void save(User user){
        System.out.println("save user.....");
        userMapper.insertSelective(user);
    }

}
