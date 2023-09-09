package com.example.shippingapp.controller;

import com.example.shippingapp.dto.SuppliersDto;
import com.example.shippingapp.dto.request.SuppliersRequest;
import com.example.shippingapp.service.SuppliersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping(value = "/suppliers")
@RequiredArgsConstructor
public class SuppliersController {
    final SuppliersService suppliersService;

    @GetMapping(value = "/suppliersList")
    public List<SuppliersDto> getSuppliersInfo(){
        return suppliersService.getAll();
    }

    @GetMapping(value = "/getSuppliersById/{id}")
    public SuppliersDto getSuppliersById(@PathVariable(value = "id")Long id){
        return suppliersService.getSuppliersById(id);
    }

    @PostMapping(value = "/saveSuppliers")
    public void saveSuppliers(@RequestBody SuppliersRequest suppliersRequest){
        suppliersService.saveSuppliers(suppliersRequest);
    }

    @PostMapping(value = "/updateSuppliers")
    public void updateSuppliers(@RequestBody SuppliersRequest suppliersRequest){
        suppliersService.updateSuppliers(suppliersRequest);
    }

    @DeleteMapping(value = "/deleteById/{id}")
    public void deleteById(@PathVariable(value = "id")Long id){
        suppliersService.deleteById(id);
    }


}
