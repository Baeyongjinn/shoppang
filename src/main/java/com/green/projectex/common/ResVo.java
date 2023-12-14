package com.green.projectex.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(title = "성공 실패 리턴값")
public class ResVo {
    private int result;
}
