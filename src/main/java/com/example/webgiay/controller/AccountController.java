package com.example.webgiay.controller;

import com.example.webgiay.dto.LoginDTO;
import com.example.webgiay.dto.RegisterDTO;
import com.example.webgiay.entity.User;
import com.example.webgiay.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dang-nhap/")
public class AccountController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private HttpSession session;

    @GetMapping("form")
    public String showFormLogin(Model model) {
        model.addAttribute("login", new LoginDTO());
        return "/user/login";
    }

    @PostMapping("login")
    public String login(@Valid @ModelAttribute("login") LoginDTO loginDTO,
                        BindingResult result,
                        HttpSession session) {
        try {
            if (result.hasErrors()) {
                return "/user/login";
            } else {
                User loggedInUser = userService.findByName(loginDTO.getName(), loginDTO.getPassword());
                if (loggedInUser != null && loggedInUser.getName() != null && loggedInUser.getPassword() != null &&
                        loggedInUser.getName().equals(loginDTO.getName()) && loggedInUser.getPassword().equals(loginDTO.getPassword())) {
                    session.setAttribute("loggedInUser", loggedInUser);
                    session.setAttribute("message", "Login success");
                    if (loggedInUser.getName().equals("admin")) {
                        session.setAttribute("message", "Login success");
                        return "redirect:/admin/dashboard";
                    } else {
                        return "redirect:/product/hien-thi";
                    }
                } else {
                    session.setAttribute("error", "Invalid username or password");
                    return "/user/login";
                }
            }
        } catch (Exception e) {
            session.setAttribute("error", "Login Fail");
            e.printStackTrace();
            return "/user/login";
        }
    }

    @GetMapping("logout")
    public String logout(HttpSession httpSession, Model model) {
        httpSession.removeAttribute("loggedInUser");
        return "redirect:/dang-nhap/form";
    }

    @GetMapping("view-register")
    public String showFormRegister(Model model) {
        model.addAttribute("registerDTO", new RegisterDTO());
        return "/user/register";
    }

    @PostMapping("create-register")
    public String Register(@Valid @ModelAttribute("registerDTO") RegisterDTO registerDTO, BindingResult bindingResult, Model model) {
        try {
            if (bindingResult.hasErrors()) {
                return "/user/register";
            }
            if (!registerDTO.getPassword().equals(registerDTO.getRepeatPassword())) {
                session.setAttribute("error", "Mật khẩu nhập lại không khớp");
                return "/user/register";
            }
            registerDTO = userService.create(registerDTO);
            session.setAttribute("message", "Tạo Tài Khoản Thành Công");
            return "redirect:/dang-nhap/form";
        } catch (Exception e) {
            e.printStackTrace();
            session.setAttribute("error", "Tạo Tài Khoản thất bại");
        }
        return "/user/register";
    }

    @GetMapping("forgot-password")
    public String formForgotPassword() {
        return "/user/forgot-password";
    }
}
