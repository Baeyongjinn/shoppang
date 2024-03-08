package com.green.projectex.user;

import com.green.projectex.common.ResVo;
import com.green.projectex.errortest.CategoryNotFoundException;
import static com.green.projectex.errortest.ErrorCode.*;
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
        if (entity == null) {
//            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
//                    , dto.getUid()
//                    , SIGNIN_UID_ERROR));
            return new ResVo(0);
        } else if (!upw.equals(dto.getUpw())) {
//            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
//                    , dto.getUpw()
//                    , SIGNIN_UPW_ERROR));
            return new ResVo(0);
        }
        return new ResVo(1);
    }

    public ResVo SigneUp(UserSignupDto dto) {
        UserEntity entity = mapper.selById(dto.getUid());
        if (entity != null) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getUid()
                    , CHECK_UID_ERROR));
        }
        mapper.signeUp(dto);
        return new ResVo(dto.getUserPk());
    }

}
