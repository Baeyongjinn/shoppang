package com.green.projectex.shopping.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "장바구니 등록 Dto")
public class ProductInsDto {

    @Schema(title = "카테고리 pk")
    private int categoryPk;
    @Schema(title = "유저 pk",defaultValue = "1")
    private int userPk;
    @Schema(title = "상품 이름")
    private String productNm;
    @Schema(title = "메모")
    private String memo;
    @Schema(title = "수량")
    private int productCount;

}
