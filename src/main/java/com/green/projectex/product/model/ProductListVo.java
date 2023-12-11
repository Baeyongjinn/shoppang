package com.green.projectex.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "장바구니 리스트 응답 Vo")
public class ProductListVo {
    @Schema(title = "상품 PK")
    private int productPk;
    @Schema(title = "카테고리 이름")
    private String categoryNm;
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
