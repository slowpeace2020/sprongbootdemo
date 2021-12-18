package com.myspringboot.controller;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @Autowired
  private DataSource dataSource;

  @GetMapping("hello")
  public String hello(){
    System.out.println("dataSource:  "+dataSource);
    return "hello spring boot!";
  }

}
