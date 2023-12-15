package com.green.projectex.product;

import com.green.projectex.category.model.CategorySelVo;
import com.green.projectex.common.Const;
import com.green.projectex.common.ResVo;
import com.green.projectex.product.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductMapper mapper;

    //구매 예정 상품 목록 리스트
    public List<ProductListVo> getProductList(ProductListDto dto) {
        if (dto.getIsList() > 2) {
            return null;
        }
        if (dto.getUserPk() < 0) {
            return null;
        }
        return mapper.selProductList(dto);
    }

    //성공: 1 실패: 0
    public ResVo postProduct(ProductInsDto dto) {
        int result = mapper.insProduct(dto);
        if (result == 0) {
            return new ResVo(Const.FAIL);
        }
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
        if (result == 0) {
            return new ResVo(Const.FAIL);
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
