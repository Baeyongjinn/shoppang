package com.green.projectex.user;

import com.green.projectex.common.ResVo;
import com.green.projectex.user.model.UserLoginedDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Logined" ,description = "로그인 API")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService service;

    @PostMapping("/signin")
    @Operation(summary = "로그인",description = "로그인 실패시: 0 , 성공시: 1 리턴")
    public ResVo loginedCheck(UserLoginedDto dto){
        return service.loginedCheck(dto);
    }
}
