package com.example.demo.services.impl;

import com.example.demo.dto.CompanyDto;
import com.example.demo.models.Company;
import com.example.demo.repository.company.CompanyDao;
import com.example.demo.services.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements CompanyServiceInterface
{
    private CompanyDao companyDao;

    @Autowired
    public CompanyService(CompanyDao companyDao)
    {
        this.companyDao = companyDao;
    }

    @Override
    public List<CompanyDto> getAllCompanies()
    {
        return this.companyDao.findAll().stream().map(company -> this.mapToCompanyDto(company)).toList();
    }

    @Override
    public Company store(Company company)
    {
        this.companyDao.save(company);
        return company;
    }

    public CompanyDto mapToCompanyDto(Company company)
    {
        return CompanyDto.builder()
                .id(company.getId())
                .companyName(company.getCompanyName())
                .build();
    }
}
