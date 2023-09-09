package com.example.shippingapp.service.impl;

import com.example.shippingapp.dto.ProductsDto;
import com.example.shippingapp.dto.request.ProductsRequest;
import com.example.shippingapp.model.Products;
import com.example.shippingapp.repository.ProductsRepository;
import com.example.shippingapp.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    final ProductsRepository productsRepository;

    @Override
    public ProductsDto getProductsById(Long id) {

        Products products = productsRepository.getProductsById(id);

        return ProductsDto.builder()
                .quantityPerUnit(products.getQuantityPerUnit())
                .reorderLevel(products.getReorderLevel())
                .unitPrice(products.getUnitPrice())
                .unitsInStock(products.getUnitsInStock())
                .unitsOnOrder(products.getUnitsOnOrder())
                .build();
    }

    @Override
    public void saveProducts(ProductsRequest productsRequest) {

        Products products = Products.builder()
                .quantityPerUnit(productsRequest.getQuantityPerUnit())
                .reorderLevel(productsRequest.getReorderLevel())
                .unitsInStock(productsRequest.getUnitsInStock())
                .unitsOnOrder(productsRequest.getUnitsOnOrder())
                .unitPrice(productsRequest.getUnitPrice())
                .build();

        productsRepository.save(products);

    }

    @Override
    public void updateProducts(ProductsRequest productsRequest) {

        Products products = Products.builder()
                .id(productsRequest.getId())
                .quantityPerUnit(productsRequest.getQuantityPerUnit())
                .reorderLevel(productsRequest.getReorderLevel())
                .unitsInStock(productsRequest.getUnitsInStock())
                .unitsOnOrder(productsRequest.getUnitsOnOrder())
                .unitPrice(productsRequest.getUnitPrice())
                .build();

        productsRepository.save(products);
    }

    @Override
    public List<ProductsDto> getAll() {

        List<Products> products = productsRepository.findAll();
        List<ProductsDto> productsDtos = new ArrayList<>();
        for(Products products1 : products){
            ProductsDto productsDto = ProductsDto.builder()
                    .quantityPerUnit(products1.getQuantityPerUnit())
                    .reorderLevel(products1.getReorderLevel())
                    .unitsInStock(products1.getUnitsInStock())
                    .unitsOnOrder(products1.getUnitsOnOrder())
                    .unitPrice(products1.getUnitPrice())
                    .build();

            productsDtos.add(productsDto);

        }

        return productsDtos;
    }

    @Override
    public void deleteById(Long id) {

        Products products = productsRepository.getProductsById(id);
        if(products.getId().equals(null)){
            throw new RuntimeException("There is mo such information");
        }
        else {
            productsRepository.deleteById(id);
        }

    }
}
