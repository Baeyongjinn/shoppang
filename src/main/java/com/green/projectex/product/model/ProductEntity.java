package com.green.projectex.product.model;

import lombok.Data;

@Data
public class ProductEntity {
    private int productPk;
    private int userPk;
    private int categoryPk;
    private String memo;
    private String createdAt;
    private int buyingCheck;
    private String buyingDate;

}
