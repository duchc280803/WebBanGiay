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
public class QLDonHangDTO {

    private Integer id;

    private String hoVaTen;

    private Integer phone;

    private BigDecimal totalMoney;

    private Integer status;

}
