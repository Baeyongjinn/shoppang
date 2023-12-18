package com.green.projectex.category;

import com.green.projectex.category.model.CategoryInsDto;
import com.green.projectex.category.model.CategorySelVo;
import com.green.projectex.common.Const;
import com.green.projectex.common.ResVo;
import com.green.projectex.errortest.CategoryNotFoundException;
import com.green.projectex.errortest.ErrorCode;
import com.green.projectex.errortest.ErrorCodeNum;
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
        if(dto.getCategoryNm().equals(checkNm)){
           throw new CategoryNotFoundException(String.format("CODE[%s]: %s", ErrorCodeNum.CODE_CATEGORY_CHECK, ErrorCode.CATEGORY_CHECK_ERROR));
        }
        if(!(dto.getCategoryNm().equals(" ") && dto.getCategoryNm() == null)) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s",ErrorCodeNum.CODE_NULL_CATEGORY,ErrorCode.NULL_CATEGORY_ERROR));
        }
        mapper.insCategory(dto);
        return new ResVo(Const.SUCCESS);
    }
}
