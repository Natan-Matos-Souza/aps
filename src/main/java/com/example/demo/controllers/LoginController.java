package com.example.demo.controllers;

import com.example.demo.dto.LoginDto;
import com.example.demo.models.Company;
import com.example.demo.repository.company.CompanyDao;
import com.example.demo.services.impl.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController
{
    private LoginService loginService;
    private CompanyDao companyDao;

    @Autowired
    public LoginController(
            LoginService loginService,
            CompanyDao companyDao
    )
    {
        this.loginService = loginService;
        this.companyDao = companyDao;
    }

    @GetMapping("/login")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("loginDto", new LoginDto());
        model.addAttribute("request", request);
        return "login";
    }

    @PostMapping("/login")
    public String authenticate(
            @ModelAttribute("loginDto") LoginDto loginDto,
            HttpSession session
    ) {

        if (!this.loginService.auth(loginDto)) {
            return "redirect:/login?invalidCredentials=true";
        }

        Company company = this.companyDao.findByCompanyEmail(loginDto.getCompanyEmail()).iterator().next();
        session.setAttribute("logged", true);
        session.setAttribute("companyEmail", loginDto.getCompanyEmail());
        session.setAttribute("companyId", company.getId());

        return "redirect:/dashboard";

    }

    @GetMapping("/logout")
    public String logout(HttpSession session)
    {
        if (this.loginService.isAuthenticated()) {
            session.invalidate();
        }

        return "redirect:/login?logout=true";
    }
}
