package com.example.shippingapp.service.impl;

import com.example.shippingapp.dto.OrderDetailsDto;
import com.example.shippingapp.dto.request.OrderDetailsRequest;
import com.example.shippingapp.model.OrderDetails;
import com.example.shippingapp.repository.OrderDetailsRepository;
import com.example.shippingapp.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderDetailsImpl implements OrderDetailsService {

    final OrderDetailsRepository orderDetailsRepository;
    @Override
    public OrderDetailsDto getOrderDetailsById(Long id) {

        OrderDetails orderDetails = orderDetailsRepository.getOrderDetailsById(id);
        return OrderDetailsDto.builder()
                .discount(orderDetails.getDiscount())
                .quantity(orderDetails.getQuantity())
                .unitPrice(orderDetails.getUnitPrice())
                .build();
    }

    @Override
    public void saveOrderDetails(OrderDetailsRequest orderDetailsRequest) {

        OrderDetails orderDetails = OrderDetails.builder()
                .discount(orderDetailsRequest.getDiscount())
                .unitPrice(orderDetailsRequest.getUnitPrice())
                .quantity(orderDetailsRequest.getQuantity())
                .build();

        orderDetailsRepository.save(orderDetails);

    }

    @Override
    public void updateOrderDetails(OrderDetailsRequest orderDetailsRequest) {

        OrderDetails orderDetails = OrderDetails.builder()
                .id(orderDetailsRequest.getId())
                .discount(orderDetailsRequest.getDiscount())
                .unitPrice(orderDetailsRequest.getUnitPrice())
                .quantity(orderDetailsRequest.getQuantity())
                .build();

        orderDetailsRepository.save(orderDetails);

    }

    @Override
    public List<OrderDetailsDto> getAll() {

        List<OrderDetails> orderDetails = orderDetailsRepository.findAll();
        List<OrderDetailsDto> orderDetailsDtos = new ArrayList<>();
        for(OrderDetails orderDetails1 : orderDetails){
            OrderDetailsDto orderDetailsDto = OrderDetailsDto.builder()
                    .unitPrice(orderDetails1.getUnitPrice())
                    .quantity(orderDetails1.getQuantity())
                    .discount(orderDetails1.getDiscount())
                    .build();

            orderDetailsDtos.add(orderDetailsDto);

        }

        return orderDetailsDtos;
    }

    @Override
    public void deleteById(Long id) {
        OrderDetails orderDetails = orderDetailsRepository.getOrderDetailsById(id);
        if(orderDetails.getId().equals(null)){
            throw new RuntimeException("");
        }
        else {
            orderDetailsRepository.deleteById(id);
        }

    }
}
