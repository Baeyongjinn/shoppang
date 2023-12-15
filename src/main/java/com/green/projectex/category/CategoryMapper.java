package com.green.projectex.category;

import com.green.projectex.category.model.CategoryInsDto;
import com.green.projectex.category.model.CategorySelVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CategoryMapper {
    List<CategorySelVo> selCategory();

    int insCategory(CategoryInsDto dto);

    String selCategoryByNm(String CategoryNm);
}
