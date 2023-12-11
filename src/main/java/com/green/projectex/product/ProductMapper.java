package com.green.projectex.product;

import com.green.projectex.product.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    List<ProductListVo> selProductList(ProductListDto dto);

    int insProduct(ProductInsDto dto);

    int patchProduct(ProductCompleteDto dto);

    int putProduct(ProductPutDto dto);

    int delProduct(ProductDelDto dto);

    int patchConfirmed(ProductPatchDto dto);
}
