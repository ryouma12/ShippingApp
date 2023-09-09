package com.example.shippingapp.repository;

import com.example.shippingapp.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Orders getOrdersById(Long id);
}
