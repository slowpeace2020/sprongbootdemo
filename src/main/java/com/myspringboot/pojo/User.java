package com.myspringboot.pojo;

import lombok.Data;

import java.util.Date;

//编译阶段根据注解自动生成GET SET方法
@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private Date created;
    private Date updated;


}
