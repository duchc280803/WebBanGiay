package com.example.webgiay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOderDTO {

    private Integer id;

    private String name;

    private Integer phone;

    private String address;

    private Integer status;
}
