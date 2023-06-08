package com.example.webgiay.service.impl;

import com.example.webgiay.dto.ProductManagerDTO;
import com.example.webgiay.dto.ProductViewDTO;
import com.example.webgiay.entity.*;
import com.example.webgiay.repository.*;
import com.example.webgiay.service.ProductManagerService;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductManagerServiceImpl implements ProductManagerService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OriginRepository originRepository;

    @Autowired
    private ColorRepository colorRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProductManagerDTO add(ProductManagerDTO productManagerDTO, Image image, ProductDetail productDetail) {
        Product existingProduct = productRepository.findByName(productManagerDTO.getName());
        Category category = categoryRepository.getById(productManagerDTO.getCategory());
        Size size = sizeRepository.getById(productManagerDTO.getSize());
        Origin origin = originRepository.getById(productManagerDTO.getOrigin());
        Color color = colorRepository.getById(productManagerDTO.getColor());

        Product product;
        if (existingProduct != null) {
            product = existingProduct;
        } else {
            product = new Product();
            product.setName(productManagerDTO.getName());
            product.setDescription(productManagerDTO.getDescription());
            product = productRepository.save(product);
        }

        image.setImage(productManagerDTO.getImage());
        image.setProduct(product);
        image = imageRepository.save(image);

        productDetail.setProduct(product);
        productDetail.setCategory(category);
        productDetail.setSize(size);
        productDetail.setOrigin(origin);
        productDetail.setColor(color);
        productDetail.setQuantity(productManagerDTO.getQuantity());
        productDetail.setPrice(productManagerDTO.getPrice());
        productDetail = productDetailRepository.save(productDetail);

        return productManagerDTO;
    }

    @Override
    public Page<ProductViewDTO> selectAllProduct(Integer pageNo, Integer pageSize) {
        if (pageNo == null || pageNo < 0) {
            pageNo = 0;
        }
        if (pageSize == null || pageSize <= 0) {
            pageSize = 9;
        }

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Object[]> pageObject = productDetailRepository.selectAllProduct(pageable);
        List<Object[]> listObject = pageObject.getContent();
        List<ProductViewDTO> productDTOList = listObject.stream()
                .map(objects -> new ProductViewDTO(
                        (Integer) objects[0],
                        (String) objects[1],
                        (String) objects[2],
                        (Integer) objects[3],
                        (String) objects[4],
                        (String) objects[5],
                        (Integer) objects[6],
                        (BigDecimal) objects[7],
                        (String) objects[8],
                        (String) objects[9]))
                .collect(Collectors.toList());
        return new PageImpl<>(productDTOList, pageable, pageObject.getTotalElements());
    }

    @Override
    public Integer countProduct() {
        List<Object[]> products = productDetailRepository.selectAllProduct();
        return products.size();
    }

    @Override
    public void update(ProductManagerDTO productManagerDTO) {
        Product product = productRepository.findById(productManagerDTO.getId()).orElse(null);

        if (product != null) {
            product.setName(productManagerDTO.getName());
            product.setDescription(productManagerDTO.getDescription());
            productRepository.save(product);

            if (!product.getListImage().isEmpty()) {
                Image image = product.getListImage().get(0);
                image.setImage(productManagerDTO.getImage());
                image.setProduct(product);
                imageRepository.save(image);
            }

            if (!product.getListProduct().isEmpty()) {
                ProductDetail productDetail = product.getListProduct().get(0);
                Category category = categoryRepository.getById(productManagerDTO.getCategory());
                Color color = colorRepository.getById(productManagerDTO.getColor());
                Origin origin = originRepository.getById(productManagerDTO.getOrigin());
                Size size = sizeRepository.getById(productManagerDTO.getSize());

                productDetail.setCategory(category);
                productDetail.setColor(color);
                productDetail.setOrigin(origin);
                productDetail.setSize(size);
                productDetail.setQuantity(productManagerDTO.getQuantity());
                productDetail.setPrice(productManagerDTO.getPrice());
                productDetailRepository.save(productDetail);
            }
        }
    }

    @Override
    public ProductViewDTO selectAllProduct(Integer id) {
        List<Object[]> listObjects = productDetailRepository.detailProductById(id);
        Object[] list = listObjects.get(0);
        Integer ids = (Integer) list[0];
        String name = (String) list[1];
        String color = (String) list[2];
        Integer size = (Integer) list[3];
        String category = (String) list[4];
        String origin = (String) list[5];
        Integer quantity = (Integer) list[6];
        BigDecimal price = (BigDecimal) list[7];
        String description = (String) list[8];
        String image = (String) list[9];
        ProductViewDTO productViewDTO = new ProductViewDTO(ids, name, color, size, category, origin, quantity, price, description, image);
        return productViewDTO;
    }

    @Override
    public List<ProductViewDTO> findByProduct(String name) {
        List<Object[]> listObjects = productDetailRepository.findByProduct(name);
        List<ProductViewDTO> productManagerDTOList = new ArrayList<>();
        for (Object[] list : listObjects) {
            Integer id = (Integer) list[0];
            String ten = (String) list[1];
            String color = (String) list[2];
            Integer size = (Integer) list[3];
            String category = (String) list[4];
            String origin = (String) list[5];
            Integer quantity = (Integer) list[6];
            BigDecimal price = (BigDecimal) list[7];
            String description = (String) list[8];
            String image = (String) list[9];
            ProductViewDTO productViewDTO = new ProductViewDTO(id, ten, color, size, category, origin, quantity, price, description, image);
            productManagerDTOList.add(productViewDTO);
        }
        return productManagerDTOList;
    }

    @Override
    public boolean delete(Integer id) {
        Product product = productRepository.getById(id);
        Optional<ProductDetail> productDetail = productDetailRepository.findById(product.getId());
        if (productDetail.isPresent()) {
            productDetailRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
