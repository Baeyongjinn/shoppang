package com.green.projectex.shopping.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
public class ProductPatchDto {
//    @Schema(title = "구매확정",defaultValue = "1",description = "0이면 예정 ,1이면 확정")
//    private int buyingCheck;
    @Schema(title = "상품 pk")
    private int productPk;
}
