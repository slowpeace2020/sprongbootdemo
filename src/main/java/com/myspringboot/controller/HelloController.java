package com.myspringboot.controller;

import javax.sql.DataSource;

import com.myspringboot.pojo.User;
import com.myspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Autowired
  private DataSource dataSource;

  @Value("${linzong.position}")
  private String position;

  @Autowired
  private UserService userService;

  /**
   * 查询用户
   * @param id
   * @return
   */
  @GetMapping("/user/{id}")
  public User getUserById(@PathVariable Long id){
    return userService.queryById(id);
  }

  @GetMapping("hello")
  public String hello(){
    System.out.println("yml:  "+position);
    System.out.println("dataSource:  "+dataSource);
    return "hello spring boot!";
  }

}
