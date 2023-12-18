package com.green.projectex.user.model;

import lombok.Data;

@Data
public class UserEntity {
    private int userPk;
    private String uid;
    private String upw;
    private String nm;
}
