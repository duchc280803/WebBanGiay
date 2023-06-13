package com.example.webgiay.controller;

import com.example.webgiay.dto.DonHangDTO;
import com.example.webgiay.entity.User;
import com.example.webgiay.service.impl.CartServiceImpl;
import com.example.webgiay.service.impl.OderServiceImpl;
import com.example.webgiay.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer/")
public class CustomerController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private OderServiceImpl oderService;

    @Autowired
    private HttpSession session;

    @GetMapping("cho-thanh-toan")
    public String choThanhToan(Model model){
        User user = (User) session.getAttribute("loggedInUser");
        List<DonHangDTO> donHangDTOList = oderService.choThanhToan(user);
        model.addAttribute("donHangDTOList",donHangDTOList);
        return "customer/cho-thanh-toan";
    }

    @GetMapping("van-chuyen")
    public String vanChuyen(Model model){
        User user = (User) session.getAttribute("loggedInUser");
        List<DonHangDTO> donHangDTOList = oderService.vanChuyen(user);
        model.addAttribute("donHangDTOList",donHangDTOList);
        return "customer/van-chuyen";
    }

    @GetMapping("dang-giao")
    public String dangGiao(Model model){
        User user = (User) session.getAttribute("loggedInUser");
        List<DonHangDTO> donHangDTOList = oderService.dangGiao(user);
        model.addAttribute("donHangDTOList",donHangDTOList);
        return "customer/dang-giao";
    }

    @GetMapping("hoan-thanh")
    public String hoanThanh(Model model){
        User user = (User) session.getAttribute("loggedInUser");
        List<DonHangDTO> donHangDTOList = oderService.hoanThanh(user);
        model.addAttribute("donHangDTOList",donHangDTOList);
        return "customer/hoan-thanh";

    }@GetMapping("da-huy")
    public String daHuy(Model model){
        User user = (User) session.getAttribute("loggedInUser");
        List<DonHangDTO> donHangDTOList = oderService.daHuy(user);
        model.addAttribute("donHangDTOList",donHangDTOList);
        return "customer/da-huy";
    }

    @GetMapping("traHangHoanTat")
    public String traHangHoanTat(Model model){
        return "customer/tra-hang-hoan-tien";
    }

    @GetMapping("khach-hang")
    public String khachHang(Model model, HttpSession session) {
        User loggedInUser = (User) session.getAttribute("loggedInUser");
        User foundUser = userService.findByUser(loggedInUser);
        model.addAttribute("user", foundUser);
        return "customer/khach";
    }

}
