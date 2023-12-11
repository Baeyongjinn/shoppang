package com.green.projectex.product;

import com.green.projectex.product.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductListVo> selShoppingList(ProductListDto dto);

    int insProduct(ProductInsDto dto);

    int patchProduct(ProductPatchDto dto);

    int putProduct(ProductPutDto dto);

    int delProduct(ProductDelDto dto);

    int patchConfirmed(ProductPatchDto dto);
}
