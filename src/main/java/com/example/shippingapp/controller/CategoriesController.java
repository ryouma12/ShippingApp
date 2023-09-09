package com.example.shippingapp.controller;

import com.example.shippingapp.dto.CategoriesDto;
import com.example.shippingapp.dto.request.CategoriesRequest;
import com.example.shippingapp.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
@RequiredArgsConstructor
public class CategoriesController {
    final CategoriesService categoriesService;

    @GetMapping(value = "/categoriesList")
    public List<CategoriesDto> getCategoriesInfo(){
        return categoriesService.getAll();
    }

    @GetMapping(value = "/getCategoriesById/{id}")
    public CategoriesDto getCategoriesById(@PathVariable(value = "id")Long id){
        return categoriesService.getCategoriesById(id);
    }

    @PostMapping(value = "/saveCategories")
    public void saveCategories(@RequestBody CategoriesRequest categoriesRequest){
        categoriesService.saveCategories(categoriesRequest);

    }

    @PostMapping(value = "/updateCategories")
    public void updateCategories(@RequestBody CategoriesRequest categoriesRequest){
        categoriesService.updateCategories(categoriesRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id){
        categoriesService.deleteById(id);
    }


}
