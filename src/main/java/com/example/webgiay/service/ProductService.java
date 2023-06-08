package com.example.webgiay.service;

import com.example.webgiay.dto.ProductDTO;
import com.example.webgiay.dto.ProductDetailDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findByProductData();

    ProductDTO findByName(String name);

    Page<ProductDTO> getAllProduct(Integer pageNo, Integer pageSize);

    ProductDetailDTO getOneDetailProduct(String name);

    ProductDTO searchByName(String name);

    Page<ProductDTO> getAllByProduct(Integer id,Integer pageNo, Integer pageSize);

    List<ProductDTO> getAllProductByCate(@Param("categoryId") Integer categoryId);

    List<ProductDTO> findByImage(@Param("name") String name);
}
