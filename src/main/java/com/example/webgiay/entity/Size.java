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
@Table(name = "Size")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "size")
    private Integer size;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "size",fetch = FetchType.LAZY)
    private List<ProductDetail> listProduct;
}
