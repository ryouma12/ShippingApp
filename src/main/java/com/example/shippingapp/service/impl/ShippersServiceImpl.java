package com.example.shippingapp.service.impl;

import com.example.shippingapp.dto.ShippersDto;
import com.example.shippingapp.dto.request.ShippersRequest;
import com.example.shippingapp.model.Shippers;
import com.example.shippingapp.repository.ShippersRepository;
import com.example.shippingapp.service.ShippersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShippersServiceImpl implements ShippersService {

    final ShippersRepository shippersRepository;
    @Override
    public ShippersDto getShippersById(Long id) {

        Shippers shippers = shippersRepository.getShippersById(id);
        return ShippersDto.builder()
                .companyName(shippers.getCompanyName())
                .phone(shippers.getPhone())
                .build();
    }

    @Override
    public void saveShippers(ShippersRequest shippersRequest) {

        Shippers shippers = Shippers.builder()
                .companyName(shippersRequest.getCompanyName())
                .phone(shippersRequest.getPhone())
                .build();

        shippersRepository.save(shippers);

    }

    @Override
    public void updateShippers(ShippersRequest shippersRequest) {

        Shippers shippers = Shippers.builder()
                .id(shippersRequest.getId())
                .companyName(shippersRequest.getCompanyName())
                .phone(shippersRequest.getPhone())
                .build();

        shippersRepository.save(shippers);

    }

    @Override
    public List<ShippersDto> getAll() {
        List<Shippers> shippers = shippersRepository.findAll();
        List<ShippersDto> shippersDtos = new ArrayList<>();
        for(Shippers shippers1 : shippers){
            ShippersDto shippersDto = ShippersDto.builder()
                    .phone(shippers1.getPhone())
                    .companyName(shippers1.getCompanyName())
                    .build();

            shippersDtos.add(shippersDto);
        }
        return shippersDtos;
    }

    @Override
    public void deleteById(Long id) {

        Shippers shippers = shippersRepository.getShippersById(id);
        if(shippers.getId().equals(null)){
            throw new RuntimeException("There is no such information");
        }
        else {
            shippersRepository.deleteById(id);
        }

    }
}
