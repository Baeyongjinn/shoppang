package com.green.projectex.user;

import com.green.projectex.common.ResVo;
import com.green.projectex.user.model.UserLoginedDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    //로그인 성공 :1 로그인 실패 :0
    public ResVo loginedCheck(UserLoginedDto dto) {
        String upw = mapper.loginedCheck(dto);
        if(!upw.equals(dto.getUpw())){
            return new ResVo(0);
        }
        return new ResVo(1);
    }

}
