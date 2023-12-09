package com.green.projectex.shopping.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductDelDto {
    @Schema(title = "상품Pk")
    private int productPk;
}
