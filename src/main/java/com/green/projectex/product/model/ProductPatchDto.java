package com.green.projectex.product.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "장바구니 구매확정 or 구매확정 상품 삭제처리 Dto")
public class ProductPatchDto {
//    @Schema(title = "구매확정",defaultValue = "1",description = "0이면 예정 ,1이면 확정")
//    private int buyingCheck;
    @Schema(title = "상품 pk")
    private int productPk;
}
