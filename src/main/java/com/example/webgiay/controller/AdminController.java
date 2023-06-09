package com.example.webgiay.controller;

import com.example.webgiay.service.impl.OderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    private OderServiceImpl oderService;

    @GetMapping("dashboard")
    public String admin(Model model){
        Integer countOderMonth = oderService.countOderMonth();
        BigDecimal totalMoney = oderService.totalMoney();
        Integer countOderDay = oderService.countOderDay();
        BigDecimal totalMoneyDay = oderService.totalMoneyDay();
        Integer countProductMonth = oderService.countProductMonth();
        model.addAttribute("countOderMonth",countOderMonth);
        model.addAttribute("totalMoney",totalMoney);
        model.addAttribute("countOderDay",countOderDay);
        model.addAttribute("totalMoneyDay",totalMoneyDay);
        model.addAttribute("countProductMonth",countProductMonth);
        return "admin/dashboard";
    }

}
