package com.example.demo.controllers;

import com.example.demo.dto.ReportDto;
import com.example.demo.services.impl.LoginService;
import com.example.demo.services.impl.ReportService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ReportController
{
    private ReportService reportService;
    private LoginService loginService;

    @Autowired
    public ReportController(ReportService reportService, LoginService loginService)
    {
        this.loginService = loginService;
        this.reportService = reportService;
    }

    @GetMapping("/reports/create")
    public String index(Model model, HttpSession session)
    {
        if (!this.loginService.isAuthenticated()) {
            return "redirect:/login";
        }

        model.addAttribute("report", new ReportDto());
        return "reports";
    }

    @PostMapping("/reports/create")
    public String store(@ModelAttribute("reportDto") ReportDto reportDto)
    {
        this.reportService.create(reportDto);
        return "redirect:/dashboard";
    }
}
