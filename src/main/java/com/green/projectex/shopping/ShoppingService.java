package com.green.projectex.shopping;

import com.green.projectex.common.ResVo;
import com.green.projectex.shopping.model.ProductInsDto;
import com.green.projectex.shopping.model.ProductPatchDto;
import com.green.projectex.shopping.model.ShoppingListDto;
import com.green.projectex.shopping.model.ShoppingListVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShoppingService {
    private final ShoppingMapper mapper;

    //구매 예정 상품 목록 리스트
    public List<ShoppingListVo> getShoppingList(ShoppingListDto dto) {
        if(dto.getIsList() == 3){
            return null;
        }
        return mapper.selShoppingList(dto);
    }

    //성공: 1 실패: 0
    public ResVo postProduct(ProductInsDto dto){
        int result = mapper.insProduct(dto);
        if(result == 0){
            return new ResVo(0);
        }
        return new ResVo(1);
    }

    public ResVo patchProductCheck(ProductPatchDto dto){
        int result = mapper.patchProduct(dto);
        if(result == 0){
            return new ResVo(0);
        }
        return new ResVo(1);
    }
}
