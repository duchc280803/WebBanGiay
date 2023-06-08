package com.example.webgiay.service.impl;

import com.example.webgiay.dto.ProductDTO;
import com.example.webgiay.dto.ProductDetailDTO;
import com.example.webgiay.entity.Product;
import com.example.webgiay.repository.ProductRepository;
import com.example.webgiay.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ProductDTO> findByProductData() {
        List<Object[]> results = productRepository.findAllProductDetails();
        List<ProductDTO> productDTOList = new ArrayList<>();

        for (Object[] reObjects : results) {
            Integer id = (Integer) reObjects[0];
            String name = (String) reObjects[1];
            BigDecimal price = (BigDecimal) reObjects[2];
            String image = (String) reObjects[3];

            ProductDTO productDTO = new ProductDTO(id,name, price, image);
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }

    @Override
    public ProductDTO findByName(String name) {
        Product product = productRepository.findByName(name);
        return modelMapper.map(product, ProductDTO.class);
    }

    @Override
    public Page<ProductDTO> getAllProduct(Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageNo < 0) {
            pageNo = 0;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 9;
        }

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Object[]> pageObjects = productRepository.findAllPage(pageable);
        List<Object[]> listObjects = pageObjects.getContent();
        List<ProductDTO> productDTOList = listObjects.stream()
                .map(objects -> new ProductDTO(
                        (Integer) objects[0],
                        (String) objects[1],
                        (BigDecimal) objects[2],
                        (String) objects[3]))
                .collect(Collectors.toList());
        return new PageImpl<>(productDTOList, pageable, pageObjects.getTotalElements());
    }

    @Override
    public Page<ProductDTO> getAllByProduct(Integer id, Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageNo < 0) {
            pageNo = 0;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 9;
        }
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Object[]> pageObjects = productRepository.findAllCategory(id,pageable);
        List<Object[]> listObjects = pageObjects.getContent();
        List<ProductDTO> productDTOList = listObjects.stream()
                .map(objects -> new ProductDTO(
                        (Integer) objects[0],
                        (String) objects[1],
                        (BigDecimal) objects[2],
                        (String) objects[3]))
                .collect(Collectors.toList());
        return new PageImpl<>(productDTOList, pageable, pageObjects.getTotalElements());
    }

    @Override
    public List<ProductDTO> getAllProductByCate(Integer categoryId) {
        List<Object[]> getAllProduct = productRepository.getAllProduct(categoryId);
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Object[] list : getAllProduct) {
            Integer id = (Integer) list[0];
            String ten = (String) list[1];
            BigDecimal price = (BigDecimal) list[2];
            String image = (String) list[3];
            ProductDTO productDTO = new ProductDTO(id,ten,price,image);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public List<ProductDTO> findByImage(String name) {
        List<Object[]> listObjects = productRepository.findByImage(name);
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Object[] list : listObjects) {
            Integer id = (Integer) list[0];
            String ten = (String) list[1];
            BigDecimal price = (BigDecimal) list[2];
            String image = (String) list[3];
            ProductDTO productDTO = new ProductDTO(id,ten,price,image);
            productDTOList.add(productDTO);
        }
        return productDTOList;
    }

    @Override
    public ProductDetailDTO getOneDetailProduct(String name) {
        List<Object[]> result = productRepository.getOneDetailProduct(name);
        Object[] row = result.get(0);
        String ten = (String) row[0];
        BigDecimal price = (BigDecimal) row[1];
        String description = (String) row[2];
        String color = (String) row[3];
        Integer size = (Integer) row[4];
        String image = (String) row[5];
        ProductDetailDTO productDetailDTO = new ProductDetailDTO(ten, price, description, color, size, image);
        return productDetailDTO;
    }

    @Override
    public ProductDTO searchByName(String name) {
        List<Object[]> result = productRepository.searchByName(name);
        Object[] row = result.get(0);
        Integer id = (Integer) row[0];
        String ten = (String) row[1];
        BigDecimal price = (BigDecimal) row[2];
        String image = (String) row[3];
        ProductDTO productDTO = new ProductDTO(id,ten, price, image);
        return productDTO;
    }

}
