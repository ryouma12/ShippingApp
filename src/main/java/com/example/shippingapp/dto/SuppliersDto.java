package com.example.shippingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
public class SuppliersDto {

    private String CompanyName;
    private String ContactName;
    private String contactTitle;
    private String adress;
    private String city;
    private String region;
    private String PostalCode;
    private String country;
    private String phone;
    private String fax;
    private String HomePage;
}
