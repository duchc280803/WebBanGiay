package com.example.webgiay.controller;

import com.example.webgiay.service.impl.OderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    private OderServiceImpl oderService;

    @GetMapping("dashboard")
    public String admin(Model model) {
        Integer countOderMonth = oderService.countOderMonth();
        BigDecimal totalMoney = oderService.totalMoney();
        Integer countOderDay = oderService.countOderDay();
        BigDecimal totalMoneyDay = oderService.totalMoneyDay();
        Integer countProductMonth = oderService.countProductMonth();
        model.addAttribute("countOderMonth", countOderMonth);
        model.addAttribute("totalMoney", totalMoney);
        model.addAttribute("countOderDay", countOderDay);
        model.addAttribute("totalMoneyDay", totalMoneyDay);
        model.addAttribute("countProductMonth", countProductMonth);
        //bar chart
        BigDecimal selectMonthJanuary = oderService.selectMonthJanuary();
        BigDecimal selectMonthFebruary = oderService.selectMonthFebruary();
        BigDecimal selectMonthMarch = oderService.selectMonthMarch();
        BigDecimal selectMonthApril = oderService.selectMonthApril();
        BigDecimal selectMonthMay = oderService.selectMonthMay();
        BigDecimal selectMonthJune = oderService.selectMonthJune();
        BigDecimal selectMonthJuly = oderService.selectMonthJuly();
        BigDecimal selectMonthAugust = oderService.selectMonthAugust();
        BigDecimal selectMonthSeptember = oderService.selectMonthSeptember();
        BigDecimal selectMonthOctober = oderService.selectMonthOctober();
        BigDecimal selectMonthNovember = oderService.selectMonthNovember();
        BigDecimal selectMonthDecember = oderService.selectMonthDecember();
        model.addAttribute("selectMonthJanuary", selectMonthJanuary);
        model.addAttribute("selectMonthFebruary", selectMonthFebruary);
        model.addAttribute("selectMonthMarch", selectMonthMarch);
        model.addAttribute("selectMonthApril", selectMonthApril);
        model.addAttribute("selectMonthMay", selectMonthMay);
        model.addAttribute("selectMonthJune", selectMonthJune);
        model.addAttribute("selectMonthJuly", selectMonthJuly);
        model.addAttribute("selectMonthAugust", selectMonthAugust);
        model.addAttribute("selectMonthSeptember", selectMonthSeptember);
        model.addAttribute("selectMonthOctober", selectMonthOctober);
        model.addAttribute("selectMonthNovember", selectMonthNovember);
        model.addAttribute("selectMonthDecember", selectMonthDecember);
        return "admin/dashboard";
    }

}
