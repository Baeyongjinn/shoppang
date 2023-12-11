package com.green.projectex.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "구매 확정 등록 Dto ")
public class ProductCompleteDto {

    @Schema(title = "유저Pk")
    private int ProductPk;
}
