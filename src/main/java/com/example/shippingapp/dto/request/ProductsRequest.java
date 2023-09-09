package com.example.shippingapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class ProductsRequest {
    private Long id;
    private String quantityPerUnit;
    private String unitPrice;
    private String unitsInStock;
    private String unitsOnOrder;
    private String reorderLevel;
}
