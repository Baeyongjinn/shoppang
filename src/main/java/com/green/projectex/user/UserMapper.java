package com.green.projectex.user;

import com.green.projectex.user.model.UserLoginedDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    String loginedCheck(UserLoginedDto dto);
}