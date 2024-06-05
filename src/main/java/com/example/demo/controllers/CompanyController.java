package com.example.demo.controllers;

import com.example.demo.models.Company;
import com.example.demo.services.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController
{

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService)
    {
        this.companyService = companyService;
    }

    @GetMapping("/company/create")
    public String create(Model model)
    {
        model.addAttribute("company", new Company());
        return "create-company";
    }

    @PostMapping("/company/create")
    public String store(@ModelAttribute("company") Company company)
    {
        this.companyService.store(company);
        return "redirect:/company/create";
    }
}