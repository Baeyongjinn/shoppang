package com.green.projectex.product;

import com.green.projectex.category.CategoryMapper;

import static com.green.projectex.common.Const.*;

import com.green.projectex.common.ResVo;
import com.green.projectex.errortest.CategoryNotFoundException;

import static com.green.projectex.errortest.ErrorCode.*;


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
        Integer userPk = userMapper.selByUser(dto.getUserPk());

        if (userPk == null) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getUserPk()
                    , NULL_USER_ERROR));
        }

        if (dto.getIsList() > 2 || dto.getIsList() < 0) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getIsList()
                    , LIST_ERROR));
        }

        return mapper.selProductList(dto);
    }

    //상품 입력
    public ResVo postProduct(ProductInsDto dto) {
        Integer categoryCheck = categoryMapper.selByCategoryPk(dto.getCategoryPk());
        Integer checkUserPk = userMapper.selByUser(dto.getUserPk());
        if (checkUserPk == null) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getUserPk()
                    , NULL_USER_ERROR));
        }
        if (categoryCheck == null) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getCategoryPk()
                    , CATEGORY_ERROR));
        }

        mapper.insProduct(dto);
        return new ResVo(dto.getProductPk());
    }

    // 구매 확정
    public ResVo patchProductCheck(ProductCompleteDto dto) {
        Integer checkUserPk = userMapper.selByUser(dto.getUserPk());
        ProductEntity entity = mapper.selEntity(dto.getProductPk());

        if (checkUserPk == null) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getUserPk()
                    , NULL_USER_ERROR));
        }
        if (entity == null) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getProductPk()
                    , PRODUCT_ERROR));
        }

        if (entity.getUserPk() != dto.getUserPk()) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getProductPk()
                    , CHECK_USER_ERROR));
        }
        if (entity.getBuyingCheck() != 0) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getProductPk()
                    , BUYING_CHECK_ERROR));
        }
        int result = mapper.patchProduct(dto);
        return new ResVo(SUCCESS);
    }


    // 상품 수정
    public ResVo putProduct(ProductPutDto dto) {
        ProductEntity entity = mapper.selEntity(dto.getProductPk());
        Integer checkUserPk = userMapper.selByUser(dto.getUserPk());
        Integer categoryCheck = categoryMapper.selByCategoryPk(dto.getCategoryPk());

        if (checkUserPk == null) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getUserPk()
                    , NULL_USER_ERROR));
        }
        if (entity == null) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getProductPk()
                    , PRODUCT_ERROR));
        }
        if (entity.getUserPk() != dto.getUserPk()) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getProductPk()
                    , CHECK_USER_ERROR));
        }

        if (categoryCheck == null) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getCategoryPk()
                    , CATEGORY_ERROR));
        }
        if (entity.getBuyingCheck() != 0) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getProductPk()
                    , BUYING_CHECK_ERROR));

        }
        int result = mapper.putProduct(dto);
        return new ResVo(SUCCESS);
    }


    // 상품 삭제
    public ResVo delProduct(ProductDelDto dto) {
        Integer checkUserPk = userMapper.selByUser(dto.getUserPk());
        ProductEntity entity = mapper.selEntity(dto.getProductPk());
        if (checkUserPk == null) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getUserPk()
                    , NULL_USER_ERROR));
        }

        if (entity == null) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getProductPk()
                    , PRODUCT_ERROR));
        }

        if (entity.getUserPk() != dto.getUserPk()) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getProductPk()
                    , CHECK_USER_ERROR));
        }

        mapper.delProduct(dto);
        mapper.patchConfirmed(dto);
        return new ResVo(SUCCESS);
    }
}
