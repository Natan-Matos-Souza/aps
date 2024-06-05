package com.example.demo.controllers;

import com.example.demo.dto.LoginDto;
import com.example.demo.services.impl.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

@Controller
public class LoginController
{
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String index(Model model) {
        model.addAttribute("loginDto", new LoginDto());
        return "login";
    }

    @PostMapping("/login")
    public String authenticate(
            @ModelAttribute("loginDto") LoginDto loginDto,
            HttpSession session,
            Model model
    ) {

        if (this.loginService.auth(loginDto)) {
            session.setAttribute("logged", true);
            session.setAttribute("companyEmail", loginDto.getCompanyEmail());
        }

        model.addAttribute("isLogged", session.getAttribute("logged"));
        return "redirect:/testLogin";
    }

    @GetMapping("/testLogin")
    public String testLogin(Model model, HttpSession session) {
        model.addAttribute("isLogged", session.getAttribute("logged"));
        return "testLogin";
    }
}
