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
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @Column(name = "category_name")
    private String categoryName;
    @Column(name = "description")
    private String description;
    @Column(name = "picture")
    private String picture;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Products> productses = new ArrayList<>();

}
