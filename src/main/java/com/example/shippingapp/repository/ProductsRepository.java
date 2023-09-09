package com.example.shippingapp.repository;

import com.example.shippingapp.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    Products getProductsById(Long id);
}
