package com.example.demo.services.impl;

import com.example.demo.dto.LoginDto;
import com.example.demo.models.Company;
import com.example.demo.repository.company.CompanyDao;
import com.example.demo.services.LoginServiceInterface;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements LoginServiceInterface
{
    private CompanyDao companyDao;
    private HttpSession session;

    @Autowired
    public LoginService(CompanyDao companyDao, HttpSession session)
    {
        this.companyDao = companyDao;
        this.session = session;
    }

    @Override
    public boolean auth(LoginDto credentials)
    {
        List<Company> companyList = companyDao.findByCompanyEmail(credentials.getCompanyEmail());
        if (companyList.isEmpty()) return false;

        Company firstCompanyFound = companyList.iterator().next();

        return firstCompanyFound.getCompanyPassword().equals(credentials.getPassword());
    }

    public boolean isAuthenticated()
    {
        if (this.session.getAttribute("logged") == null) return false;

        return (boolean) this.session.getAttribute("logged");
    }
}
