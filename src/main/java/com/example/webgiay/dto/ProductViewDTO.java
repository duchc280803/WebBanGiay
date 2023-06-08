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
public class ProductViewDTO {

        private Integer id;

        private String name;

        private String color;

        private Integer size;

        private String category;

        private String origin;

        private Integer quantity;

        private BigDecimal price;

        private String description;

        private String image;
}
