package com.example.webgiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<Image> listImage;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<ProductDetail> listProduct;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<DiscountProduct> listDiscountProduct;
}
