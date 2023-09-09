package com.example.shippingapp.service;

import com.example.shippingapp.dto.ShippersDto;
import com.example.shippingapp.dto.request.ShippersRequest;

import java.util.List;

public interface ShippersService {

    ShippersDto getShippersById(Long id);
    void saveShippers(ShippersRequest shippersRequest);
    void updateShippers(ShippersRequest shippersRequest);
    List<ShippersDto> getAll();
    void deleteById(Long id);

}
