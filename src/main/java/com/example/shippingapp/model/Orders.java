package com.example.shippingapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @Column(name = "order_date")
    private String orderDate;
    @Column(name = "required_date")
    private String requiredDate;
    @Column(name = "shipped_date")
    private String shippedDate;
    @Column(name = "ship_via")
    private String shipVia;
    @Column(name = "freight")
    private String freight;
    @Column(name = "ship_name")
    private String shipName;
    @Column(name = "ship_address")
    private String shipAddress;
    @Column(name = "ship_city")
    private String shipCity;
    @Column(name = "ship_region")
    private String shipRegion;
    @Column(name = "ship_postal_code")
    private String shipPostalCode;
    @Column(name = "ship_country")
    private String shipCountry;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetails> orderDetailses = new ArrayList<>();

}
