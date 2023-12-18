package com.green.projectex.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "회원가입")
public class UserSignupDto {
    @JsonIgnore
    private int userPk;

    @Schema(title = "유저Id")
    private String uid;
    @Schema(title = "유저Pw")
    private String upw;
    @Schema(title = "유저Nm")
    private String nm;
}
