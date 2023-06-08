package com.example.webgiay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private Integer idCustomer;

    private BigDecimal unitPrice;

    private Integer idCart;

    private Integer idProduct;

    private String nameProduct;

    private Integer quantity;

    private Date dateCreate;

    private Date dateFix;
}
