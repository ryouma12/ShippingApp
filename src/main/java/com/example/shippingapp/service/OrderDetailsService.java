package com.example.shippingapp.service;

import com.example.shippingapp.dto.OrderDetailsDto;
import com.example.shippingapp.dto.request.OrderDetailsRequest;

import java.util.List;

public interface OrderDetailsService {

    OrderDetailsDto getOrderDetailsById(Long id);
    void saveOrderDetails(OrderDetailsRequest orderDetailsRequest);
    void updateOrderDetails(OrderDetailsRequest orderDetailsRequest);

    List<OrderDetailsDto> getAll();

    void deleteById(Long id);

}
