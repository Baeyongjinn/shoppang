package com.green.projectex.product.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "구매확정 상품 삭제처리 Dto(여러개 한번에 처리 가능)")
public class ProductPatchDto {
//    @Schema(title = "구매확정",defaultValue = "1",description = "0이면 예정 ,1이면 확정")
//    private int buyingCheck;
    @Schema(title = "상품 pk")
    private List<Integer> productPk;
}
