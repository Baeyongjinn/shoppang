package com.green.projectex.category;

import com.green.projectex.category.model.CategoryInsDto;
import com.green.projectex.category.model.CategorySelVo;
import com.green.projectex.common.Const;
import com.green.projectex.common.ResVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryMapper mapper;

    public List<CategorySelVo> selCategory(){
        return mapper.selCategory();
    }

    public ResVo insCategory(CategoryInsDto dto){
        String checkNm = mapper.selCategoryByNm(dto.getCategoryNm());
        log.info("checkNm: {}",checkNm);

        if(checkNm == null){
            mapper.insCategory(dto);
            log.info("checkNm: {}",checkNm);
            return new ResVo(Const.SUCCESS);
        }
        return new ResVo(Const.FAIL);
    }
}
