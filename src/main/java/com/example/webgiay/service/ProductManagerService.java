package com.example.webgiay.service;

import com.example.webgiay.dto.ProductDTO;
import com.example.webgiay.dto.ProductManagerDTO;
import com.example.webgiay.dto.ProductViewDTO;
import com.example.webgiay.entity.Image;
import com.example.webgiay.entity.ProductDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductManagerService {

    ProductManagerDTO add(ProductManagerDTO productManagerDTO, Image image, ProductDetail productDetail);

    Page<ProductViewDTO> selectAllProduct(Integer pageNo, Integer pageSize);

    Integer countProduct();

    void update(ProductManagerDTO productManagerDTO);

    ProductViewDTO selectAllProduct(Integer id);

    List<ProductViewDTO> findByProduct(@Param("name") String name);

    boolean delete(Integer id);

    Page<ProductViewDTO> selectAllProductCategory(Integer id, Integer pageNo, Integer pageSize);
}
