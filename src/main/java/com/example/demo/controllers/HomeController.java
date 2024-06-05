package com.example.demo.controllers;

import com.example.demo.dto.CompanyDto;
import com.example.demo.services.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private CompanyService companyService;

    @Autowired
    public HomeController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/")
    public String index(Model model) {

        List<CompanyDto> companies = this.companyService.getAllCompanies();

        model.addAttribute("data", companies);
        return "index";
    }
}
