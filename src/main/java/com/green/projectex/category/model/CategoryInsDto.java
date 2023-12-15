package com.green.projectex.category.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(title = "카테고리 목록 추가 Dto")
@Data
public class CategoryInsDto {
    @JsonIgnore
    private int categoryPk;
    @Schema(title = "카테고리 이름")
    private String categoryNm;
}
