package com.example.demo.repository.company;

import com.example.demo.models.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface CompanyDao extends JpaRepository<Company, Long>
{
    List<Company> findByCompanyEmail(String email);
}
