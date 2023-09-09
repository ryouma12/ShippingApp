package com.example.shippingapp.controller;

import com.example.shippingapp.dto.OrderDetailsDto;
import com.example.shippingapp.dto.request.OrderDetailsRequest;
import com.example.shippingapp.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orderdetails")
@RequiredArgsConstructor
public class OrderDetailsController {
    final OrderDetailsService orderDetailsService;

    @GetMapping(value = "/orderdetailsList")
    public List<OrderDetailsDto> getOrderDetailsInfo(){
        return orderDetailsService.getAll();
    }

    @GetMapping(value = "/getOrderDetailsById/{id}")
    public OrderDetailsDto getOrderDetailsById(@PathVariable(value = "id")Long id){

        return orderDetailsService.getOrderDetailsById(id);

    }

    @PostMapping(value = "/saveOrderDetails")
    public void saveOrderDetails(@RequestBody OrderDetailsRequest orderDetailsRequest){
        orderDetailsService.saveOrderDetails(orderDetailsRequest);

    }

    @PostMapping(value = "/updateOrderDetails")
    public void updateOrderDetails(@RequestBody OrderDetailsRequest orderDetailsRequest){
        orderDetailsService.updateOrderDetails(orderDetailsRequest);
    }
    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id") Long id)
    {
        orderDetailsService.deleteById(id);
    }


}
