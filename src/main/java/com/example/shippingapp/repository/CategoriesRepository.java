package com.example.shippingapp.repository;

import com.example.shippingapp.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories, Long> {
    Categories getCategoriesById(Long id);
}
