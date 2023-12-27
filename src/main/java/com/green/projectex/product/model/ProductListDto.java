package com.green.projectex.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(title = "리스트 응답 Dto",description = "장바구니 리스트 응답 DTO")
@Data
public class ProductListDto {
    @Schema(title = "유저pk")
    private int userPk;
    @Schema(title = "볼것 리스트 번호" ,defaultValue = "0")
    private int choiceList;
//    @Schema(title = "날짜 별로 보고 싶을 때 입력",defaultValue = " ")
//    private String createdAt;
}
