package com.example.shippingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ProductsDto {

    private String quantityPerUnit;
    private String unitPrice;
    private String unitsInStock;
    private String unitsOnOrder;
    private String reorderLevel;
}
