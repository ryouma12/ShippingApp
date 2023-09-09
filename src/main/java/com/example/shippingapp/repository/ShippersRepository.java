package com.example.shippingapp.repository;

import com.example.shippingapp.model.Shippers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippersRepository extends JpaRepository<Shippers, Long> {
    Shippers getShippersById(Long id);
}
