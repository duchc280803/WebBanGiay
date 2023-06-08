package com.example.webgiay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDetailDTO {

    private Integer idProductDetail;

    private Integer idCart;

    private String image;

    private String name;

    private BigDecimal price;

    private Integer quantity;

    private Integer size;

    private Integer status;
}
