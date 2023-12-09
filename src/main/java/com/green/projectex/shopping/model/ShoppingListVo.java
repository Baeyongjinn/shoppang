package com.green.projectex.shopping.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ShoppingListVo {
    @Schema(title = "상품 카테고리")
    private String categoryList;
    @Schema(title = "상품 이름")
    private String productNm;
    @Schema(title = "메모")
    private String memo;
    @Schema(title = "상품수량")
    private int count;
    @Schema(title = "구매확정",description = "0이면 예정 1이면 확정")
    private int buyingCheck;
    @Schema(title = "구매 확정 날짜")
    private String buyingDate;
}
