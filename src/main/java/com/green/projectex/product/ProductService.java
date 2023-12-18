package com.green.projectex.product;

import com.green.projectex.category.CategoryMapper;
import com.green.projectex.category.model.CategorySelVo;
import com.green.projectex.common.Const;
import com.green.projectex.common.ResVo;
import com.green.projectex.errortest.CategoryNotFoundException;
import com.green.projectex.errortest.ErrorCode;
import com.green.projectex.errortest.ErrorCodeNum;
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
        if (dto.getIsList() > 2) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , ErrorCodeNum.CODE_LIST, ErrorCode.LIST_ERROR));
        }
        if (userPk == null) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , ErrorCodeNum.CODE_USER, ErrorCode.USER_ERROR));
        }
        return mapper.selProductList(dto);
    }

    //성공: 1 실패: 0
    //상품 입력
    public ResVo postProduct(ProductInsDto dto) {
        Integer categoryCheck = categoryMapper.selByCategoryPk(dto.getCategoryPk());
        Integer checkUserPk = userMapper.selByUser(dto.getUserPk());
        if(checkUserPk == null){
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , ErrorCodeNum.CODE_USER, ErrorCode.USER_ERROR));
        }
        if (categoryCheck == null) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , ErrorCodeNum.CODE_CATEGORY, ErrorCode.CATEGORY_ERROR));
        }

        mapper.insProduct(dto);
        return new ResVo(dto.getProductPk());
    }

    // 구매 확정
    public ResVo patchProductCheck(ProductCompleteDto dto) {
        Integer checkUserPk = userMapper.selByUser(dto.getUserPk());
        ProductEntity entity = mapper.selEntity(dto.getProductPk());
        if (entity == null) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , ErrorCodeNum.CODE_PRODUCT, ErrorCode.PRODUCT_ERROR));
        }
        if (checkUserPk == null) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , ErrorCodeNum.CODE_USER, ErrorCode.USER_ERROR));
        }
        if (entity.getUserPk() != dto.getUserPk()) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , ErrorCodeNum.CODE_USER_CHECK, ErrorCode.CHECK_USER_ERROR));
        }
        if (entity.getBuyingCheck() != 0) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , ErrorCodeNum.CODE_BUYING_CHECK, ErrorCode.BUYING_CHECK_ERROR));
        }
        int result = mapper.patchProduct(dto);
        return new ResVo(Const.SUCCESS);
    }


    // 상품 수정
    public ResVo putProduct(ProductPutDto dto) {
        ProductEntity entity = mapper.selEntity(dto.getProductPk());
        Integer categoryCheck = categoryMapper.selByCategoryPk(dto.getCategoryPk());
        Integer checkUserPk = userMapper.selByUser(dto.getUserPk());
        if (checkUserPk == null) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , ErrorCodeNum.CODE_USER, ErrorCode.USER_ERROR));
        }
        if (entity == null) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , ErrorCodeNum.CODE_PRODUCT, ErrorCode.PRODUCT_ERROR));
        }
        if (categoryCheck == null) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , ErrorCodeNum.CODE_CATEGORY, ErrorCode.CATEGORY_ERROR));
        }
        if (entity.getBuyingCheck() != 0) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , ErrorCodeNum.CODE_BUYING_CHECK, ErrorCode.BUYING_CHECK_ERROR));

        }
        int result = mapper.putProduct(dto);
        return new ResVo(Const.SUCCESS);
    }


    // 상품 삭제
    public ResVo delProduct(ProductDelDto dto) {
        Integer checkUserPk = userMapper.selByUser(dto.getUserPk());
        ProductEntity entity = mapper.selEntity(dto.getProductPk());
        if (checkUserPk == null) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , ErrorCodeNum.CODE_USER, ErrorCode.USER_ERROR));
        }

        if (entity == null) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , dto.getProductPk(), ErrorCode.PRODUCT_ERROR));
        }

        if (entity.getUserPk() != dto.getUserPk()) {
            throw new CategoryNotFoundException(String.format("CODE[%s]: %s"
                    , ErrorCodeNum.CODE_USER_CHECK, ErrorCode.CHECK_USER_ERROR));
        }


        int affectedRows = mapper.delProduct(dto);
        int affectedRows2 = mapper.patchConfirmed(dto);

        return new ResVo(Const.SUCCESS);
    }
}
