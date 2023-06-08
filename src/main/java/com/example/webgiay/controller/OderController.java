package com.example.webgiay.controller;

import com.example.webgiay.dto.*;
import com.example.webgiay.entity.Oder;
import com.example.webgiay.entity.User;
import com.example.webgiay.service.impl.CartServiceImpl;
import com.example.webgiay.service.impl.OderServiceImpl;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/oder/")
public class OderController {

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    private HttpSession session;

    @Autowired
    private OderServiceImpl oderService;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        List<QLDonHangDTO> donHangDTOList = oderService.quanLyDonHang();
        model.addAttribute("donHangDTOList", donHangDTOList);
        return "admin/oder";
    }

    @GetMapping("detail/{id}")
    public String oderDetail(@PathVariable("id") Integer id, Model model) {
        CustomerOderDTO customerOderDTO = oderService.customerOder(id);
        List<CustomerProductDTO> customerProductDTOS = oderService.productOfCustomer(id);
        model.addAttribute("customerOderDTO", customerOderDTO);
        model.addAttribute("customerProductDTOS", customerProductDTOS);
        return "admin/oder-detail";
    }

    @GetMapping("view-thanh-toan")
    public String viewThanhToan(Model model) {
        User user = (User) session.getAttribute("loggedInUser");
        List<CartDetailDTO> cartDetailDTOS = cartService.cartDetailDTO(user);
        model.addAttribute("cartDetailDTOS", cartDetailDTOS);
        model.addAttribute("oderDTO", new OderDTO());
        return "customer/view-thanh-toan";
    }

    @PostMapping("create")
    public String createOder(@Valid @ModelAttribute("oderDTO") OderDTO oderDTO, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return "customer/view-thanh-toan";
            }
            User user = (User) session.getAttribute("loggedInUser");
            Oder oder = new Oder();
            List<CartDetailDTO> cartDetailDTOS = cartService.cartDetailDTO(user);
            oderDTO = oderService.create(user, oder, cartDetailDTOS, oderDTO);
            session.setAttribute("message", "Đặt Hàng Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Đặt Hàng Thất Bại");
        }
        return "customer/view-thanh-toan";
    }

    @PostMapping("update/{id}")
    public String updateStatus(@PathVariable("id") Integer id,
                               @ModelAttribute("oder") Oder oder,
                               BindingResult result) {
        try {
            if (result.hasErrors()) {
                return "admin/oder-detail";
            }
            oderService.updateStatus(oder,id);
            session.setAttribute("message", "Thành Công");
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Thất Bại");
        }
        return "redirect:/oder/hien-thi";
    }
}
