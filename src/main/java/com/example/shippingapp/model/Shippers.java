package com.example.shippingapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "shippers")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shippers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shipper_id")
    private Long id;
    @Column(name = "company_Name")
    private String companyName;
    @Column(name = "phone")
    private String phone;


}
