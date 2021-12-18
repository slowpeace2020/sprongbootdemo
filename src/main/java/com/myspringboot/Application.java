package com.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot工程都有一个启动引导类，为工程的入口类
 */

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class,args);
  }
}
