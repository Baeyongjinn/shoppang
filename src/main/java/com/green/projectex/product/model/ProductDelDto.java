package com.green.projectex.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "장바구니 삭제 Dto(여러게 한번에 처리 가능)")
public class ProductDelDto {
    @Schema(title = "상품Pk")
    private List<Integer> productPk;
}
