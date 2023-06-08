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
public class CustomerProductDTO {

    private String image;

    private String name;

    private Integer size;

    private Integer quantity;

    private BigDecimal unitPrice;

}
