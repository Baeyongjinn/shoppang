package com.green.projectex.shopping;

import com.green.projectex.shopping.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingMapper {

    List<ShoppingListVo> selShoppingList(ShoppingListDto dto);

    int insProduct(ProductInsDto dto);

    int patchProduct(ProductPatchDto dto);

    int putProduct(ProductPutDto dto);

    int delProduct(ProductDelDto dto);
}
