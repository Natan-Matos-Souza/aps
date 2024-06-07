package com.example.demo.controllers;

import com.example.demo.dto.ReportDto;
import com.example.demo.services.impl.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReportController
{
    private ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService)
    {
        this.reportService = reportService;
    }

    @GetMapping("/reports/create")
    public String index(Model model)
    {
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
