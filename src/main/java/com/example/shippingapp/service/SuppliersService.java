package com.example.shippingapp.service;

import com.example.shippingapp.dto.SuppliersDto;
import com.example.shippingapp.dto.request.SuppliersRequest;

import java.util.List;

public interface SuppliersService {

    SuppliersDto getSuppliersById(Long id);
    void saveSuppliers(SuppliersRequest suppliersRequest);
    void updateSuppliers(SuppliersRequest suppliersRequest);
    List<SuppliersDto> getAll();
    void deleteById(Long id);

}
