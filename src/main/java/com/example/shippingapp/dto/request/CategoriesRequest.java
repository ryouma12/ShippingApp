package com.example.shippingapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriesRequest {
    private Long id;
    private String categoryName;
    private String description;
    private String picture;
}
