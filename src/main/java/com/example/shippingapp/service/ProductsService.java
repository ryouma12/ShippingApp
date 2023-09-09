package com.example.shippingapp.service;

import com.example.shippingapp.dto.ProductsDto;
import com.example.shippingapp.dto.request.ProductsRequest;

import java.util.List;

public interface ProductsService {

    ProductsDto getProductsById(Long id);

    void saveProducts(ProductsRequest productsRequest);
    void updateProducts(ProductsRequest productsRequest);
    List<ProductsDto> getAll();
    void deleteById(Long id);
}
