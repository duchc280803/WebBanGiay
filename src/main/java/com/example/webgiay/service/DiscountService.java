package com.example.webgiay.service;

import com.example.webgiay.dto.DiscountDTO;
import com.example.webgiay.dto.DiscountDetailDTO;
import com.example.webgiay.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DiscountService {

    List<Product> getAll();

    DiscountDTO create(DiscountDTO discountDTO);

    Page<DiscountDetailDTO> getAllDtos(Integer pageNo, Integer pageSize);

    DiscountDetailDTO getOneDetailDiscount(String ma);
}
