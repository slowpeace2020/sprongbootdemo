package com.myspringboot.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//编译阶段根据注解自动生成GET SET方法
@Data
@Table(name = "tb_user")
public class User {
    @Id
    //主键回填
    @KeySql(useGeneratedKeys = true)
    private Long id;

    //@Column("othername") 当数据库的字段名不符合驼峰规则或者下划线间隔，手动指定映射关系
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private Integer sex;
    private Date birthday;
    private Date created;
    private Date updated;


}
