package com.example.shippingapp.controller;

import com.example.shippingapp.dto.ShippersDto;
import com.example.shippingapp.dto.request.ShippersRequest;
import com.example.shippingapp.service.ShippersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/shippers")
@RequiredArgsConstructor
public class ShippersController {
    final ShippersService shippersService;

    @GetMapping(value = "/shippersList")
    public List<ShippersDto> getShippersInfo() {
        return shippersService.getAll();
    }

    @GetMapping(value = "/getShippersById/{id}")
    public ShippersDto getShippersById(@PathVariable(value = "id") Long id) {
        return shippersService.getShippersById(id);
    }

    @PostMapping(value = "/saveShippers")
    public void saveShippers(@RequestBody ShippersRequest shippersRequest){
        shippersService.saveShippers(shippersRequest);
    }

    @PostMapping(value = "/updateShippers")
    public void updateShippers(@RequestBody ShippersRequest shippersRequest){
        shippersService.updateShippers(shippersRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id){
        shippersService.deleteById(id);
    }
}
