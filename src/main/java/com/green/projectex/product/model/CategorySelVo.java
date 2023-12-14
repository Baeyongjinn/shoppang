package com.green.projectex.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(title = "카테고리 목록 확인")
public class CategorySelVo {
    private int categoryPk;
    private String categoryNm;
}
