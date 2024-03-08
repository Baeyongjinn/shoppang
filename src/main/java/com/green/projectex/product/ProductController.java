package com.green.projectex.product;


import com.green.projectex.category.model.CategorySelVo;
import com.green.projectex.common.ResVo;
import com.green.projectex.errortest.CategoryNotFoundException;
import com.green.projectex.product.model.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.green.projectex.errortest.ErrorCode.LIST_ERROR;
import static com.green.projectex.errortest.ErrorCode.NULL_USER_ERROR;

@Tag(name = "product", description = "장바구니 API")
@Slf4j
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping
    @Operation(summary = "구매 목록 조회", description = "구매 목록 조회 처리(choiceList: 0 모두 보기, 1:구매예정 상품 보기 , 2: 구매확정 상품 보기) , buyingCheck 0: 구매예정, 1: 구매확정")
    public List<ProductListVo> getProductList(ProductListDto dto) {
        log.info("dto: {}", dto);
        if (dto.getChoiceList() > 2 || dto.getChoiceList()  < 0) {
            throw new CategoryNotFoundException(String.format("ID[%s]: %s"
                    , dto.getChoiceList()
                    , LIST_ERROR));
        }
        if(dto.getUserPk() == 2){
            return new ArrayList<>();
        }
        return service.getProductList(dto);
    }

    @PostMapping
    @Operation(summary = "구매 상품 등록", description = "구매 상품 등록 처리")
    public ResVo postProduct(@RequestBody ProductInsDto dto) {
        log.info("dto: {}", dto);
        return service.postProduct(dto);
    }

    @PatchMapping()
    @Operation(summary = "구매 확정", description = "구매 확정 처리")
    public ResVo patchProductCheck(ProductCompleteDto dto) {
        log.info("dto: {}", dto);
        return service.patchProductCheck(dto);
    }

    @PutMapping()
    @Operation(summary = "구매 예정 상품 수정", description = "구매 예정 상품 수정 처리")
    public ResVo putProduct(@RequestBody ProductPutDto dto) {
        log.info("dto: {}", dto);
        return service.putProduct(dto);
    }

    @DeleteMapping()
    @Operation(summary = "상품 삭제", description = "상품 삭제 처리(구매 예정 상품은 영구 삭제,구매 확정 상품은 update로 삭제 처리 )")
    public ResVo delProduct(ProductDelDto dto) {
        return service.delProduct(dto);
    }
}
