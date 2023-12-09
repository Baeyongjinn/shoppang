package com.green.projectex.shopping.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
public class ShoppingListDto {
    @Schema(title = "유저pk",description = "default pk값 1로 줌",defaultValue = "1")
    private int iuser;

    private int isList;
}
