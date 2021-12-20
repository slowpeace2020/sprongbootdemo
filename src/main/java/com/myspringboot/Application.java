package com.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * springboot工程都有一个启动引导类，为工程的入口类
 */

@SpringBootApplication
//扫描mybatis所有业务mapper接口 官方import org.mybatis.spring.annotation.MapperScan;
@MapperScan("com.myspringboot.mapper")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class,args);
  }
}
