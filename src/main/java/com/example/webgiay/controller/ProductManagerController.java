package com.example.webgiay.controller;

import com.example.webgiay.dto.ProductDTO;
import com.example.webgiay.dto.ProductManagerDTO;
import com.example.webgiay.dto.ProductViewDTO;
import com.example.webgiay.entity.*;
import com.example.webgiay.service.impl.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product-manager/")
public class ProductManagerController {

    @Autowired
    private ProductManagerServiceImpl productManagerService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @Autowired
    private SizeServiceImpl sizeServiceImpl;

    @Autowired
    private ColorServiceImpl colorService;

    @Autowired
    private OriginServiceImpl originService;

    @Autowired
    private HttpSession session;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("hien-thi-product")
    public String hienThi(@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                          @RequestParam(value = "pageSize", defaultValue = "9") Integer pageSize,
                          Model model) {
        if (pageNumber < 0) {
            pageNumber = 0;
        }
        Page<ProductViewDTO> results = productManagerService.selectAllProduct(pageNumber, pageSize);
        List<ProductViewDTO> productDetailDTOList = results.getContent();
        Integer soLuong = productManagerService.countProduct();
        model.addAttribute("productDetailDTOList", productDetailDTOList);
        model.addAttribute("results", results);
        model.addAttribute("soLuong", soLuong);
        return "admin/product-management";
    }

    @PostMapping("create")
    public String create(@Valid @ModelAttribute("productManagerDTO") ProductManagerDTO productManagerDTO,
                         BindingResult bindingResult,
                         @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                         @RequestParam(value = "pageSize", defaultValue = "9") Integer pageSize,
                         Model model) {
        try {
            if (bindingResult.hasErrors()) {
                return "admin/view-create";
            }
            if (pageNumber < 0) {
                pageNumber = 0;
            }
            ProductDetail productDetail = new ProductDetail();
            Product product = new Product();
            Image image = new Image();
            productManagerDTO = productManagerService.add(productManagerDTO, image, productDetail);
            Page<ProductViewDTO> result = productManagerService.selectAllProduct(pageNumber, pageSize);
            List<ProductViewDTO> productDetailDTOList = result.getContent();
            model.addAttribute("result", result);
            model.addAttribute("productDetailDTOList", productDetailDTOList);
            session.setAttribute("message", "Add Thành Công");
        } catch (Exception ex) {
            session.setAttribute("error", "Add thất bại");
            ex.printStackTrace();
        }
        return "redirect:/product-manager/hien-thi-product";
    }

    @GetMapping("hien-thi-product/search")
    public String findByProduct(@RequestParam("name") String name, Model model) {
        List<ProductViewDTO> productDetailDTOList = productManagerService.findByProduct(name);
        Integer soLuong = productManagerService.countProduct();
        model.addAttribute("productDetailDTOList", productDetailDTOList);
        model.addAttribute("soLuong", soLuong);
        return "admin/product-management";
    }

    @GetMapping("view-create")
    public String viewCreate(Model model) {
        model.addAttribute("productManagerDTO", new ProductManagerDTO());
        return "admin/view-create";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") Integer id, Model model) {
        ProductViewDTO productViewDTOList = productManagerService.selectAllProduct(id);
        List<Size> size = sizeServiceImpl.getAll();
        model.addAttribute("size", size);
        model.addAttribute("productViewDTOList", productViewDTOList);
        model.addAttribute("productViewDTO", new ProductViewDTO());
        return "admin/view-update";
    }

    @PostMapping("update")
    public String update(@Valid @ModelAttribute("productManagerDTO") ProductManagerDTO productManagerDTO,
                         BindingResult bindingResult,
                         @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                         @RequestParam(value = "pageSize", defaultValue = "9") Integer pageSize,
                         Model model) {
        try {
            if (bindingResult.hasErrors()) {
                return "admin/view-update";
            }
            if (pageNumber < 0) {
                pageNumber = 0;
            }

            productManagerService.update(productManagerDTO);
            Page<ProductViewDTO> result = productManagerService.selectAllProduct(pageNumber, pageSize);
            List<ProductViewDTO> productDetailDTOList = result.getContent();
            model.addAttribute("result", result);
            model.addAttribute("productDetailDTOList", productDetailDTOList);
            session.setAttribute("message", "Update Thành Công");
        } catch (Exception ex) {
            session.setAttribute("error", "Update thất bại");
            ex.printStackTrace();
        }
        return "redirect:/product-manager/hien-thi-product";
    }

    @GetMapping("category/{id}")
    public String findByCategory(@PathVariable("id") Integer id,
                                 @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                                 @RequestParam(value = "pageSize", defaultValue = "9") Integer pageSize,
                                 Model model) {
        if (pageNumber < 0) {
            pageNumber = 0;
        }
        Page<ProductViewDTO> results = productManagerService.selectAllProductCategory(id, pageNumber, pageSize);
        List<ProductViewDTO> productList = results.getContent();
        model.addAttribute("productList", productList);
        model.addAttribute("results", results);
        return "/product/product";
    }

    @ModelAttribute("categoryIds")
    public Map<Integer, String> getCategory() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        List<Category> categoryList = categoryService.getAll();
        for (Category c : categoryList
        ) {
            map.put(c.getId(), c.getName());
        }
        return map;
    }

    @ModelAttribute("originId")
    public Map<Integer, String> getOrigin() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        List<Origin> origin = originService.getAll();
        for (Origin c : origin
        ) {
            map.put(c.getId(), c.getName());
        }
        return map;
    }

    @ModelAttribute("sizeId")
    public Map<Integer, Integer> getSize() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Size> size = sizeServiceImpl.getAll();
        for (Size c : size
        ) {
            map.put(c.getId(), c.getSize());
        }
        return map;
    }

    @ModelAttribute("colorId")
    public Map<Integer, String> getColer() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        List<Color> color = colorService.getAll();
        for (Color c : color
        ) {
            map.put(c.getId(), c.getName());
        }
        return map;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        try {
            productManagerService.delete(id);
            session.setAttribute("message", "Xóa Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Xóa Thất Bại");
        }
        return "redirect:/product-manager/hien-thi-product";
    }

}