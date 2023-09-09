package com.example.shippingapp.service.impl;

import com.example.shippingapp.dto.OrdersDto;
import com.example.shippingapp.dto.request.OrdersRequest;
import com.example.shippingapp.model.Orders;
import com.example.shippingapp.repository.OrdersRepository;
import com.example.shippingapp.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrdersServiceImpl implements OrdersService {

    final OrdersRepository ordersRepository;
    @Override
    public OrdersDto getOrdersById(Long id) {

        Orders orders = ordersRepository.getOrdersById(id);
        return OrdersDto.builder()
                .orderDate(orders.getOrderDate())
                .freight(orders.getFreight())
                .shipAddress(orders.getShipAddress())
                .requiredDate(orders.getRequiredDate())
                .shipCity(orders.getShipCity())
                .shipName(orders.getShipName())
                .shipCountry(orders.getShipCountry())
                .shippedDate(orders.getShippedDate())
                .shipPostalCode(orders.getShipPostalCode())
                .shipRegion(orders.getShipRegion())
                .shipVia(orders.getShipVia())
                .build();
    }

    @Override
    public void saveOrders(OrdersRequest ordersRequest) {

        Orders orders = Orders.builder()
                .orderDate(ordersRequest.getOrderDate())
                .freight(ordersRequest.getFreight())
                .shipAddress(ordersRequest.getShipAddress())
                .requiredDate(ordersRequest.getRequiredDate())
                .shipCity(ordersRequest.getShipCity())
                .shipName(ordersRequest.getShipName())
                .shipCountry(ordersRequest.getShipCountry())
                .shippedDate(ordersRequest.getShippedDate())
                .shipPostalCode(ordersRequest.getShipPostalCode())
                .shipRegion(ordersRequest.getShipRegion())
                .shipVia(ordersRequest.getShipVia())
                .build();

        ordersRepository.save(orders);

    }

    @Override
    public void updateOrders(OrdersRequest ordersRequest) {
        Orders orders = Orders.builder()
                .id(ordersRequest.getId())
                .orderDate(ordersRequest.getOrderDate())
                .freight(ordersRequest.getFreight())
                .shipAddress(ordersRequest.getShipAddress())
                .requiredDate(ordersRequest.getRequiredDate())
                .shipCity(ordersRequest.getShipCity())
                .shipName(ordersRequest.getShipName())
                .shipCountry(ordersRequest.getShipCountry())
                .shippedDate(ordersRequest.getShippedDate())
                .shipPostalCode(ordersRequest.getShipPostalCode())
                .shipRegion(ordersRequest.getShipRegion())
                .shipVia(ordersRequest.getShipVia())
                .build();

        ordersRepository.save(orders);

    }

    @Override
    public List<OrdersDto> getAll() {
        List<Orders> orders = ordersRepository.findAll();
        List<OrdersDto> ordersDtos = new ArrayList<>();
        for(Orders orders1 : orders){
            OrdersDto ordersDto = OrdersDto.builder()
                    .orderDate(orders1.getOrderDate())
                    .freight(orders1.getFreight())
                    .shipAddress(orders1.getShipRegion())
                    .requiredDate(orders1.getRequiredDate())
                    .shipCity(orders1.getShipCity())
                    .shipName(orders1.getShipName())
                    .shipCountry(orders1.getShipCountry())
                    .shippedDate(orders1.getShippedDate())
                    .shipPostalCode(orders1.getShipPostalCode())
                    .shipRegion(orders1.getShipRegion())
                    .shipVia(orders1.getShipVia())
                    .build();

            ordersDtos.add(ordersDto);
        }
        return ordersDtos;
    }

    @Override
    public void deleteById(Long id) {

        Orders orders = ordersRepository.getOrdersById(id);
        if(orders.getId().equals(null)){
            throw new RuntimeException("");
        }
        else {
            ordersRepository.deleteById(id);
        }

    }
}
