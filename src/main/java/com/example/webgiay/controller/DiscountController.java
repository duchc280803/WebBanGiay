package com.example.webgiay.controller;

import com.example.webgiay.dto.DiscountDTO;
import com.example.webgiay.dto.DiscountDetailDTO;
import com.example.webgiay.entity.Product;
import com.example.webgiay.service.impl.DiscountServiceImpl;
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
@RequestMapping("/discount/")
public class DiscountController {

    @Autowired
    private DiscountServiceImpl discountServiceImpl;

    @GetMapping("hien-thi")
    public String viewDiscount(@RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                               @RequestParam(value = "pageSize", defaultValue = "9") Integer pageSize,
                               Model model) {
        Page<DiscountDetailDTO> page = discountServiceImpl.getAllDtos(pageNumber,pageSize);
        List<DiscountDetailDTO> discountDetailDTOList = page.getContent();
        model.addAttribute("list", discountDetailDTOList);
        model.addAttribute("results", page);
        return "discount/view-discount";
    }

    @GetMapping("view-create")
    public String viewCreateDiscount(Model model){
        List<Product> results = discountServiceImpl.getAll();
        model.addAttribute("list", results);
        model.addAttribute("discountDTO",new DiscountDTO());
        return "discount/view-create";
    }

    @PostMapping("create")
    public String createDiscount(@Valid @ModelAttribute("discountDTO") DiscountDTO discountDTO,
                                 @RequestParam(value = "pageNumber", defaultValue = "0") Integer pageNumber,
                                 @RequestParam(value = "pageSize", defaultValue = "9") Integer pageSize,
                                 BindingResult result, Model model, HttpSession session) {
        try {
            if (result.hasErrors()) {
                return "discount/view-create";
            }
            discountDTO = discountServiceImpl.create(discountDTO);
            Page<DiscountDetailDTO> page = discountServiceImpl.getAllDtos(pageNumber,pageSize);
            List<DiscountDetailDTO> discountDetailDTOList = page.getContent();
            model.addAttribute("list", discountDetailDTOList);
            model.addAttribute("results", page);
            session.setAttribute("message", "Thêm Khuyến Mãi Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Thêm Khuyến Mãi Thất Bại");
            List<Product> results = discountServiceImpl.getAll();
            model.addAttribute("list", results);
            return "discount/view-create";
        }
        return "redirect:/discount/hien-thi";
    }

    @GetMapping("view-update/{ma}")
    public String detailDiscount(@PathVariable("ma") String ma, Model model) {
        DiscountDetailDTO discountDetailDTO = discountServiceImpl.getOneDetailDiscount(ma);
        List<Product> results = discountServiceImpl.getAll();
        if (discountDetailDTO == null) {
            // Xử lý trường hợp không tìm thấy chi tiết khuyến mãi
            return "error"; // hoặc bạn có thể chuyển hướng hoặc hiển thị thông báo lỗi phù hợp
        }
        model.addAttribute("list", results);
        model.addAttribute("discountDetailDTO", discountDetailDTO);
        model.addAttribute("discountDTO", new DiscountDetailDTO());
        return "discount/view-update";
    }

    @ModelAttribute("HinhThucKhuyenMai")
    public Map<Integer, String> getHinhThucDiscount() {
        Map<Integer, String> getHinhThucDiscount = new HashMap<Integer, String>();
        getHinhThucDiscount.put(1, "Giảm Theo %");
        getHinhThucDiscount.put(2, "Giảm Theo Số Tiền");
        return getHinhThucDiscount;
    }

    @ModelAttribute("trangThai")
    public Map<Integer, String> getTrangThai() {
        Map<Integer, String> getTrangThai = new HashMap<Integer, String>();
        getTrangThai.put(1, "Hoạt Động");
        getTrangThai.put(2, "Không Hoạt Động");
        return getTrangThai;
    }
}
