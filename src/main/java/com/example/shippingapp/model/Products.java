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
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;
    @Column(name = "unit_price")
    private String unitPrice;
    @Column(name = "units_in_stock")
    private String unitsInStock;
    @Column(name = "units_on_order")
    private String unitsOnOrder;
    @Column(name = "reorder_level")
    private String reorderLevel;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Categories categories;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Suppliers suppliers;

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetails> orderDetailses = new ArrayList<>();

}