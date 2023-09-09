package com.example.shippingapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailsRequest {
    private Long id;
    private String unitPrice;
    private String quantity;
    private String discount;
}
