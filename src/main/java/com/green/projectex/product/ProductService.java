package com.green.projectex.product;

import com.green.projectex.common.Const;
import com.green.projectex.common.ResVo;
import com.green.projectex.product.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductMapper mapper;

    //구매 예정 상품 목록 리스트
    public List<ProductListVo> getProductList(ProductListDto dto) {
        if(dto.getIsList() > 2){
            return null;
        }
        return mapper.selProductList(dto);
    }

    //성공: 1 실패: 0
    public ResVo postProduct(ProductInsDto dto){
        int result = mapper.insProduct(dto);
        if(result == 0){
            return new ResVo(Const.FAIL);
        }
        return new ResVo(dto.getProductPk());
    }

    public ResVo patchProductCheck(ProductCompleteDto dto){
        int result = mapper.patchProduct(dto);
        if(result == 0){
            return new ResVo(Const.FAIL);
        }
        return new ResVo(Const.SUCCESS);
    }

    public ResVo putProduct(ProductPutDto dto){
        int result = mapper.putProduct(dto);
        if(result == 0) {
            return new ResVo(Const.FAIL);
        }
        return new ResVo(Const.SUCCESS);
    }
    public List<CategorySelVo> selCategory(){
        return mapper.selCategory();
    }

    public ResVo delProduct(ProductDelDto dto){
        mapper.delProduct(dto);
        mapper.patchConfirmed(dto);
        return new ResVo(Const.SUCCESS);
    }
}
