package com.green.projectex.category;

import com.green.projectex.category.model.CategoryInsDto;
import com.green.projectex.category.model.CategorySelVo;
import com.green.projectex.common.ResVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
@Tag(name = "Category",description = "카테고리 API")
public class CategoryController {

    private final CategoryService service;
    @GetMapping
    @Operation(summary = "카테고리 리스트 보기",description = "카테고리 리스트 보기 처리")
    public List<CategorySelVo> getCategory(){
        return service.selCategory();
    }

    @PostMapping
    @Operation(summary = "카테고리 추가",description = "성공시: 1")
    public ResVo insCategory(@RequestBody CategoryInsDto dto){
        return service.insCategory(dto);
    }

    @DeleteMapping
    public ResVo delCategory(int categoryPk){
        return service.delCategory(categoryPk);
    }
}
