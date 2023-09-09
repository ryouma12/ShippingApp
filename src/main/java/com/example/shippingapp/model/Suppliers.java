package com.example.shippingapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "suppliers")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Suppliers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long id;
    @Column(name = "company_name")
    private String CompanyName;
    @Column(name = "contact_name")
    private String ContactName;
    @Column(name = "contact_title")
    private String contactTitle;
    @Column(name = "adress")
    private String adress;
    @Column(name = "city")
    private String city;
    @Column(name = "region")
    private String region;
    @Column(name = "postal_code")
    private String PostalCode;
    @Column(name = "country")
    private String country;
    @Column(name = "phone")
    private String phone;
    @Column(name = "fax")
    private String fax;
    @Column(name = "home_page")
    private String HomePage;

    @OneToMany(mappedBy = "suppliers", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Products> productses = new ArrayList<>();

}
