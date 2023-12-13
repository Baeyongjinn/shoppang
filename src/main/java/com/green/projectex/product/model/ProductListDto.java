package com.green.projectex.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "장바구니 리스트 응답 DTO")
@Data
public class ProductListDto {
    @Schema(title = "유저pk",description = "default pk값 1로 줌",defaultValue = "1")
    private int userPk;
    @Schema(title = "볼것 리스트 번호" ,defaultValue = "0")
    private int isList;
}