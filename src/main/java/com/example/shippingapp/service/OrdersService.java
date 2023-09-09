package com.example.shippingapp.service;

import com.example.shippingapp.dto.OrdersDto;
import com.example.shippingapp.dto.request.OrdersRequest;

import java.util.List;

public interface OrdersService {

    OrdersDto getOrdersById(Long id);

    void saveOrders(OrdersRequest ordersRequest);
    void updateOrders(OrdersRequest ordersRequest);
    List<OrdersDto> getAll();
    void deleteById(Long id);

}
