package com.example.shippingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailsDto {

    private String unitPrice;
    private String quantity;
    private String discount;

}
