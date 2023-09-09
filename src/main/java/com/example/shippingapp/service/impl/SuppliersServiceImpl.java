package com.example.shippingapp.service.impl;

import com.example.shippingapp.dto.SuppliersDto;
import com.example.shippingapp.dto.request.SuppliersRequest;
import com.example.shippingapp.model.Suppliers;
import com.example.shippingapp.repository.SuppliersRepository;
import com.example.shippingapp.service.SuppliersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SuppliersServiceImpl implements SuppliersService {

    final SuppliersRepository suppliersRepository;
    @Override
    public SuppliersDto getSuppliersById(Long id) {
        Suppliers suppliers = suppliersRepository.getSuppliersById(id);

        return SuppliersDto.builder()
                .CompanyName(suppliers.getCompanyName())
                .ContactName(suppliers.getContactName())
                .contactTitle(suppliers.getContactTitle())
                .adress(suppliers.getAdress())
                .city(suppliers.getCity())
                .region(suppliers.getRegion())
                .PostalCode(suppliers.getPostalCode())
                .country(suppliers.getCountry())
                .phone(suppliers.getPhone())
                .fax(suppliers.getFax())
                .HomePage(suppliers.getHomePage())
                .build();
    }

    @Override
    public void saveSuppliers(SuppliersRequest suppliersRequest) {

        Suppliers suppliers = Suppliers.builder()
                .CompanyName(suppliersRequest.getCompanyName())
                .ContactName(suppliersRequest.getContactName())
                .contactTitle(suppliersRequest.getContactTitle())
                .adress(suppliersRequest.getAdress())
                .city(suppliersRequest.getCity())
                .region(suppliersRequest.getRegion())
                .PostalCode(suppliersRequest.getPostalCode())
                .country(suppliersRequest.getCountry())
                .phone(suppliersRequest.getPhone())
                .fax(suppliersRequest.getFax())
                .HomePage(suppliersRequest.getHomePage())
                .build();

        suppliersRepository.save(suppliers);

    }

    @Override
    public void updateSuppliers(SuppliersRequest suppliersRequest) {
        Suppliers suppliers = Suppliers.builder()
                .id(suppliersRequest.getId())
                .CompanyName(suppliersRequest.getCompanyName())
                .ContactName(suppliersRequest.getContactName())
                .contactTitle(suppliersRequest.getContactTitle())
                .adress(suppliersRequest.getAdress())
                .city(suppliersRequest.getCity())
                .region(suppliersRequest.getRegion())
                .PostalCode(suppliersRequest.getPostalCode())
                .country(suppliersRequest.getCountry())
                .phone(suppliersRequest.getPhone())
                .fax(suppliersRequest.getFax())
                .HomePage(suppliersRequest.getHomePage())
                .build();

        suppliersRepository.save(suppliers);

    }

    @Override
    public List<SuppliersDto> getAll() {

        List<Suppliers> suppliers = suppliersRepository.findAll();
        List<SuppliersDto> suppliersDtos = new ArrayList<>();
        for (Suppliers suppliers1 : suppliers){
            SuppliersDto suppliersDto = SuppliersDto.builder()
                    .CompanyName(suppliers1.getCompanyName())
                    .ContactName(suppliers1.getContactName())
                    .contactTitle(suppliers1.getContactTitle())
                    .adress(suppliers1.getAdress())
                    .city(suppliers1.getCity())
                    .region(suppliers1.getRegion())
                    .PostalCode(suppliers1.getPostalCode())
                    .country(suppliers1.getCountry())
                    .phone(suppliers1.getPhone())
                    .fax(suppliers1.getFax())
                    .HomePage(suppliers1.getHomePage())
                    .build();
            suppliersDtos.add(suppliersDto);
        }

        return suppliersDtos;
    }

    @Override
    public void deleteById(Long id) {

        Suppliers suppliers = suppliersRepository.getSuppliersById(id);
        if(suppliers.getId().equals(null)){
            throw new RuntimeException("");

        }
        else {
            suppliersRepository.deleteById(id);
        }

    }
}
