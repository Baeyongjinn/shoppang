package com.green.projectex.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "장바구니 삭제 Dto ")
public class ProductDelDto {
    @Schema(title = "상품Pk")
    private int productPk;
}
