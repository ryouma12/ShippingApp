package com.example.shippingapp.repository;

import com.example.shippingapp.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
            OrderDetails getOrderDetailsById(Long id);
}
