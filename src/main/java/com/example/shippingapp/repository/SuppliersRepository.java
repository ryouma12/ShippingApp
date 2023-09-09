package com.example.shippingapp.repository;

import com.example.shippingapp.model.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers, Long> {
    Suppliers getSuppliersById(Long id);
}
