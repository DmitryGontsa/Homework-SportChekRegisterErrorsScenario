package com.hillel.ua.page_object.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductModel {

    public ProductModel() {
    }

    private String productTitle;
    private String productColour;
    private String productSize;
    private String productQuantity;
    private String productPrice;
    private String productEstimatedTotalPrice;
}
