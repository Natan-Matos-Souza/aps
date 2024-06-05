package com.example.demo.services;

import com.example.demo.dto.CompanyDto;
import com.example.demo.models.Company;

import java.util.List;

public interface CompanyServiceInterface
{
    List<CompanyDto> getAllCompanies();
    Company store(Company company);
}