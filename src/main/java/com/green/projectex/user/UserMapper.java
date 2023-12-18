package com.green.projectex.user;

import com.green.projectex.user.model.UserEntity;
import com.green.projectex.user.model.UserSignInDto;
import com.green.projectex.user.model.UserSignupDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    Integer selByUser(int userPk);

    String loginedCheck(UserSignInDto dto);

    int signeUp(UserSignupDto dto);

    UserEntity selById(String uid);


}
