package com.green.projectex.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "장바구니 수정 Dto")
public class ProductPutDto {
    @Schema(title = "상품Pk")
    private int productPk;
    @Schema(title = "상품 이름")
    private String productNm;
    @Schema(title = "카테고리 Pk")
    private int categoryPk;
    @Schema(title = "메모")
    private String memo;
}
