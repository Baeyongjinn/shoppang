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
    public List<ProductListVo> getShoppingList(ProductListDto dto) {
        if(dto.getIsList() > 2){
            return null;
        }
        return mapper.selShoppingList(dto);
    }

    //성공: 1 실패: 0
    public ResVo postProduct(ProductInsDto dto){
        int result = mapper.insProduct(dto);
        if(result == 0){
            return new ResVo(Const.FAIL);
        }
        return new ResVo(Const.SUCCESS);
    }

    public ResVo patchProductCheck(ProductPatchDto dto){
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

    public ResVo delProduct(ProductDelDto dto) {
        int result = mapper.delProduct(dto);
        if(result == 0){
            return new ResVo(Const.FAIL);
        }
        return new ResVo(Const.SUCCESS);
    }

    public ResVo patchConfirmed(ProductPatchDto dto){
        int result = mapper.patchConfirmed(dto);
        if(result == 0) {
            return new ResVo(Const.FAIL);
        }
        return new ResVo(Const.SUCCESS);
    }
}
