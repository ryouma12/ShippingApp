package com.example.shippingapp.service;

import com.example.shippingapp.dto.CategoriesDto;
import com.example.shippingapp.dto.request.CategoriesRequest;

import java.util.List;

public interface CategoriesService {
    CategoriesDto getCategoriesById(Long id);

    void saveCategories(CategoriesRequest categoriesRequest);
    void updateCategories(CategoriesRequest categoriesRequest);

    List<CategoriesDto> getAll();

    void deleteById(Long id);



}
