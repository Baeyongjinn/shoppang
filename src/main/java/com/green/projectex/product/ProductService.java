package com.green.projectex.product;

import com.green.projectex.category.CategoryMapper;
import com.green.projectex.category.model.CategorySelVo;
import com.green.projectex.common.Const;
import com.green.projectex.common.ResVo;
import com.green.projectex.errortest.CategoryNotFoundException;
import com.green.projectex.errortest.ErrorCode;
import com.green.projectex.product.model.*;
import com.green.projectex.user.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductMapper mapper;
    private final CategoryMapper categoryMapper;
    private final UserMapper userMapper;

    //구매 예정 상품 목록 리스트
    public List<ProductListVo> getProductList(ProductListDto dto) {
        if (dto.getIsList() > 2) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s",dto.getIsList(),ErrorCode.LIST_ERROR));
        }
        Integer userPk = userMapper.selByUser(dto.getUserPk());
        if (userPk == null) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s",dto.getUserPk(), ErrorCode.USER_ERROR));
        }
        return mapper.selProductList(dto);
    }

    //성공: 1 실패: 0
    public ResVo postProduct(ProductInsDto dto) {
        Integer categoryCheck = categoryMapper.selByCategoryPk(dto.getCategoryPk());
        if(categoryCheck == null){
            throw new CategoryNotFoundException(String.format("ID[%s]: %s",dto.getCategoryPk(),ErrorCode.CATEGORY_ERROR));
        }
        mapper.insProduct(dto);
        return new ResVo(dto.getProductPk());
    }

    public ResVo patchProductCheck(ProductCompleteDto dto) {
        int result = mapper.patchProduct(dto);

        if (result == 0) {
            return new ResVo(Const.FAIL);
        }
        return new ResVo(Const.SUCCESS);
    }

    public ResVo putProduct(ProductPutDto dto) {
        int result = mapper.putProduct(dto);
        ProductEntity entity = mapper.selEntity(dto.getProductPk());
        Integer categoryCheck = categoryMapper.selByCategoryPk(dto.getCategoryPk());
        if (entity == null) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s",dto.getProductPk(),ErrorCode.PRODUCT_ERROR));
        }
        if(categoryCheck == null){
            throw new CategoryNotFoundException(String.format("ID[%s]: %s",dto.getCategoryPk(),ErrorCode.CATEGORY_ERROR));
        }
        if(entity.getBuyingCheck() != 0 ){
            throw new CategoryNotFoundException(String.format("ID[%s]: %s",entity.getBuyingCheck(),ErrorCode.BUYING_CHECK_ERROR));

        }
        return new ResVo(Const.SUCCESS);
    }


    public ResVo delProduct(ProductDelDto dto) {
        int affectedRows = mapper.delProduct(dto);
        int affectedRows2 = mapper.patchConfirmed(dto);
        if (affectedRows == 0) {
            return new ResVo(Const.FAIL);
        }


        return new ResVo(Const.SUCCESS);
    }
}
