package com.example.webgiay.dto;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDTO {

    private Integer idSanPham;

    @NotBlank(message = "Ma is required")
    private String maDiscount;

    @NotBlank(message = "Name is required")
    private String name;

    private Integer HinhThucKhuyenMai;

    @NotNull(message = "Mức Giảm Giá is required")
    private Integer mucGiamGia;

    @NotNull(message = "Please enter start date")
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayBatDau;

    @NotNull(message = "Please enter start end")
    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayKetThuc;

    private Integer trangThai;

    private String product;

}
