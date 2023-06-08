package com.example.webgiay.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DiscountProduct")
public class DiscountProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Id_product",referencedColumnName = "ID")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "Id_voucher",referencedColumnName = "ID")
    private Discount discount;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "so_tien_con_lai")
    private BigDecimal soTienConLai;

    @Column(name = "status")
    private Integer status;
}
