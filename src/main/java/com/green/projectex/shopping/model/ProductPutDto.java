package com.green.projectex.shopping.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
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
