package com.green.projectex.user;

import com.green.projectex.common.ResVo;
import com.green.projectex.errortest.CategoryNotFoundException;
import com.green.projectex.errortest.ErrorCode;
import com.green.projectex.errortest.ErrorCodeNum;
import com.green.projectex.user.model.UserEntity;
import com.green.projectex.user.model.UserSignInDto;
import com.green.projectex.user.model.UserSignupDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper mapper;

    //로그인 성공 :1 로그인 실패 :0
    public ResVo loginedCheck(UserSignInDto dto) {
        String upw = mapper.loginedCheck(dto);
        UserEntity entity = mapper.selById(dto.getUid());
        if(entity == null){
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s",ErrorCodeNum.CODE_SIGNIN_UID,ErrorCode.SIGNIN_UID_ERROR));
        }
        else if(!upw.equals(dto.getUpw())){
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s",ErrorCodeNum.CODE_SIGNIN_UPW,ErrorCode.SIGNIN_UPW_ERROR));
        }
        return new ResVo(1);
    }

    public ResVo SigneUp(UserSignupDto dto){
        UserEntity entity = mapper.selById(dto.getUid());
        if(entity != null) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s", ErrorCodeNum.CODE_CHECK_UID, ErrorCode.CHECK_UID_ERROR));
        }
        mapper.signeUp(dto);
        return new ResVo(dto.getUserPk());
    }

}
