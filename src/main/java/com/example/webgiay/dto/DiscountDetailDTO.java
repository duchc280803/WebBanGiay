package com.example.webgiay.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDetailDTO {

    private String maKM;

    private String tenChuongTrinh;

    private Integer hinhThucKhuyenMai;

    private Integer giamGia;

    private String tenSanPham;

    private Date ngayBatDau;

    private Date ngayKetThuc;

    private Integer trangThai;
}
