package com.example.shippingapp.service.impl;

import com.example.shippingapp.dto.CategoriesDto;
import com.example.shippingapp.dto.request.CategoriesRequest;
import com.example.shippingapp.model.Categories;
import com.example.shippingapp.repository.CategoriesRepository;
import com.example.shippingapp.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {

    final CategoriesRepository categoriesRepository;
    @Override
    public CategoriesDto getCategoriesById(Long id) {
        Categories categories = categoriesRepository.getCategoriesById(id);

        return CategoriesDto.builder()
                .categoryName(categories.getCategoryName())
                .description(categories.getDescription())
                .picture(categories.getPicture())
                .build();
    }

    @Override
    public void saveCategories(CategoriesRequest categoriesRequest) {

        Categories categories = Categories.builder()
                .categoryName(categoriesRequest.getCategoryName())
                .description(categoriesRequest.getDescription())
                .picture(categoriesRequest.getPicture())
                .build();

        categoriesRepository.save(categories);

    }

    @Override
    public void updateCategories(CategoriesRequest categoriesRequest) {

        Categories categories = Categories.builder()
                .id(categoriesRequest.getId())
                .categoryName(categoriesRequest.getCategoryName())
                .description(categoriesRequest.getDescription())
                .picture(categoriesRequest.getPicture())
                .build();

        categoriesRepository.save(categories);


    }

    @Override
    public List<CategoriesDto> getAll() {

        List<Categories> categories = categoriesRepository.findAll();
        List<CategoriesDto> categoriesDtos = new ArrayList<>();
        for (Categories categories1 : categories){
            CategoriesDto categoriesDto = CategoriesDto.builder()
                    .picture(categories1.getPicture())
                    .description(categories1.getDescription())
                    .categoryName(categories1.getCategoryName())
                    .build();

            categoriesDtos.add(categoriesDto);
        }


        return categoriesDtos;
    }

    @Override
    public void deleteById(Long id) {

        Categories categories = categoriesRepository.getCategoriesById(id);
        if(categories.getId().equals(null)) {
            throw new RuntimeException("");
        }
        else {
            categoriesRepository.deleteById(id);
        }

    }
}
