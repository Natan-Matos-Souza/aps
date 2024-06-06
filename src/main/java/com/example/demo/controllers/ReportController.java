package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReportController
{
    @GetMapping("/reports/create")
    public String index()
    {
        return "reports";
    }

    @PostMapping("/reports/create")
    public String store()
    {
        return "redirect:/dashboard";
    }
}
