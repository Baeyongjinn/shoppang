package com.green.projectex.shopping;


import com.green.projectex.common.ResVo;
import com.green.projectex.shopping.model.ProductInsDto;
import com.green.projectex.shopping.model.ProductPatchDto;
import com.green.projectex.shopping.model.ShoppingListDto;
import com.green.projectex.shopping.model.ShoppingListVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "product", description = "장바구니 API")
@Slf4j
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ShoppingController {
    private final ShoppingService service;

    @GetMapping
    @Operation(summary = "구매 목록 조회", description = "구매 목록 조회 처리")
    public List<ShoppingListVo> getShoppingList(ShoppingListDto dto) {
        log.info("dto: {}",dto);
        return service.getShoppingList(dto);
    }

    @PostMapping
    @Operation(summary = "구매 상품 등록", description = "구매 상품 등록 처리")
    public ResVo postProduct(@RequestBody ProductInsDto dto) {
        log.info("dto: {}",dto);
        return service.postProduct(dto);
    }

    @PatchMapping()
    @Operation(summary = "구매 확정", description = "구매 확정 처리")
    public ResVo patchProductCheck(ProductPatchDto dto) {
        log.info("dto: {}",dto);
        return service.patchProductCheck(dto);
    }
}
