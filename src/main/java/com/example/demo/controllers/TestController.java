package com.example.demo.controllers;

import com.example.demo.services.impl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController
{
    private LoginService loginService;

    @Autowired
    public TestController(LoginService loginService)
    {
        this.loginService = loginService;
    }

    @GetMapping("/private")
    public String index()
    {
        if (!this.loginService.isAuthenticated()) return "redirect:/login";

        return "private";
    }
}
