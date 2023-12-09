package com.green.projectex.shopping;

import com.green.projectex.shopping.model.ProductInsDto;
import com.green.projectex.shopping.model.ProductPatchDto;
import com.green.projectex.shopping.model.ShoppingListDto;
import com.green.projectex.shopping.model.ShoppingListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingMapper {

    List<ShoppingListVo> selShoppingList(ShoppingListDto dto);

    int insProduct(ProductInsDto dto);

    int patchProduct(ProductPatchDto dto);
}
