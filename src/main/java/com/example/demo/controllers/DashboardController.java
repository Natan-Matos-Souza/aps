package com.example.demo.controllers;

import com.example.demo.services.impl.LoginService;
import com.example.demo.services.impl.ReportService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController
{
    private ReportService reportService;
    private LoginService loginService;

    @Autowired
    public DashboardController(ReportService reportService, LoginService loginService)
    {
        this.loginService = loginService;
        this.reportService = reportService;
    }

    @GetMapping("/dashboard")
    public String index(Model model, HttpSession session)
    {
        if (!this.loginService.isAuthenticated()) {
            return "redirect:/login";
        }

        model.addAttribute("reports", this.reportService.getReportsFromUser((Long) session.getAttribute("companyId")));
        return "dashboard";
    }
}
