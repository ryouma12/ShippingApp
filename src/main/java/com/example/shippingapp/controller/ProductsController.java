package com.example.shippingapp.controller;

import com.example.shippingapp.dto.ProductsDto;
import com.example.shippingapp.dto.request.ProductsRequest;
import com.example.shippingapp.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
@RequiredArgsConstructor
public class ProductsController {

    final ProductsService productsService;

    @GetMapping(value = "/productsList")
    public List<ProductsDto> getProductsInfo(){
        return productsService.getAll();
    }

    @GetMapping(value = "/getProductsById/{id}")
    public ProductsDto getProductsById(@PathVariable(value = "id")Long id){
        return productsService.getProductsById(id);
    }

    @PostMapping(value = "/saveProducts")
    public void saveProducts(@RequestBody ProductsRequest productsRequest){
        productsService.saveProducts(productsRequest);
    }

    @PostMapping(value = "/updateProdcuts")
    public void updateProducts(@RequestBody ProductsRequest productsRequest){
        productsService.updateProducts(productsRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id){
        productsService.deleteById(id);
    }


}
