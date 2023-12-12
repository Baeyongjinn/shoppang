package com.green.projectex.product.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "구매 확정 상품 삭제 처리 Dto(여러개 한번에 처리 가능)")
public class ProductPatchDto {
    
    @Schema(title = "상품 pk")
    private List<Integer> productPk;
}
