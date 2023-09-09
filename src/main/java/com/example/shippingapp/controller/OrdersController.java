package com.example.shippingapp.controller;

import com.example.shippingapp.dto.OrdersDto;
import com.example.shippingapp.dto.request.OrdersRequest;
import com.example.shippingapp.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
@RequiredArgsConstructor
public class OrdersController {

    final OrdersService ordersService;
    @GetMapping(value = "/ordersList")
    public List<OrdersDto> getOrderInfo(){
        return ordersService.getAll();
    }

    @GetMapping(value = "/getOrdersById/{id}")
    public OrdersDto getOrdersById(@PathVariable(value = "id")Long id){
        return ordersService.getOrdersById(id);

    }

    @PostMapping(value = "/saveOrders")
    public void saveOrders(@RequestBody OrdersRequest ordersRequest){
        ordersService.saveOrders(ordersRequest);

    }

    @PostMapping(value = "/updateOrders")
    public void updateOrders(@RequestBody OrdersRequest ordersRequest){
        ordersService.updateOrders(ordersRequest);
    }
    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id){
        ordersService.deleteById(id);
    }

}
