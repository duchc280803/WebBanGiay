package com.example.webgiay.controller;

import com.example.webgiay.dto.ProductDTO;
import com.example.webgiay.dto.ProductDetailDTO;
import com.example.webgiay.entity.Category;
import com.example.webgiay.service.impl.CategoryServiceImpl;
import com.example.webgiay.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        List<ProductDTO> results = productServiceImpl.findByProductData();
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("list", results);
        return "index";
    }

    @GetMapping("view-product")
    public String sanPham(@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                          @RequestParam(value = "pageSize", defaultValue = "9") Integer pageSize,
                          Model model) {
        if (pageNumber < 0) {
            pageNumber = 0;
        }
        List<Category> categoryList = categoryService.getAll();
        Page<ProductDTO> results = productServiceImpl.getAllProduct(pageNumber, pageSize);
        List<ProductDTO> productList = results.getContent();
        model.addAttribute("productList", productList);
        model.addAttribute("results", results);
        model.addAttribute("categoryList", categoryList);
        return "/product/product";
    }

    @GetMapping("product-detail/{name}")
    public String detailProduct(@PathVariable("name") String name, Model model) {
        ProductDetailDTO productDetailDTO = productServiceImpl.getOneDetailProduct(name);
        List<ProductDTO> productDTOS = productServiceImpl.findByImage(name);
        model.addAttribute("productDetailDTO", productDetailDTO);
        model.addAttribute("productDTOS", productDTOS);
        return "product/product-detail";
    }

    @GetMapping("search/{name}")
    public String findByName(@PathVariable("name") String name, Model model) {
        ProductDTO productDTO = productServiceImpl.searchByName(name);
        model.addAttribute("list", productDTO);
        return "forward:/product/hien-thi";
    }

    @GetMapping("category/{id}")
    public String findByCategory(@PathVariable("id") Integer id,
                                 @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                                 @RequestParam(value = "pageSize", defaultValue = "9") Integer pageSize,
                                 Model model) {
        if (pageNumber < 0) {
            pageNumber = 0;
        }
        List<Category> categoryList = categoryService.getAll();
        Page<ProductDTO> results = productServiceImpl.getAllByProduct(id, pageNumber, pageSize);
        List<ProductDTO> productList = results.getContent();
        model.addAttribute("productList", productList);
        model.addAttribute("results", results);
        model.addAttribute("categoryList", categoryList);
        return "/product/product";
    }
}
