package com.example.webgiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CartDetail")
public class CartDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Id_cart",referencedColumnName = "ID")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "Id_product",referencedColumnName = "ID")
    private ProductDetail productDetail;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "date_create")
    private Date dateCreate;

    @Column(name = "date_fix")
    private Date dateFix;

    @Column(name = "status")
    private Integer status;
}