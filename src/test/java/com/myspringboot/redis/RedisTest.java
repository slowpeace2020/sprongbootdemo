package com.myspringboot.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        //string
        redisTemplate.opsForValue().set("taizu","林纵");
        System.out.println("太祖 = "+redisTemplate.opsForValue().get("taizu"));
        //hash
        redisTemplate.boundHashOps("谋士").putIfAbsent("性情中人","杜隐");
        redisTemplate.boundHashOps("谋士").putIfAbsent("不苟言笑","审遇");
        //获取所有域
        Set set = redisTemplate.boundHashOps("谋士").keys();
        System.out.println(set);
        //获取所有值
        List values = redisTemplate.boundHashOps("谋士").values();
        System.out.println(values);
        //set
        //list
        //sorted set
    }
}
