package com.myspringboot.mapper;

import com.myspringboot.pojo.User;
import tk.mybatis.mapper.common.Mapper;

//@Mapper 不推荐
public interface UserMapper extends Mapper<User> {
}
