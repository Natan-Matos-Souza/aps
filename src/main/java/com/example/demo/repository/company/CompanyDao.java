package com.example.demo.repository.company;

import com.example.demo.models.Company;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface CompanyDao extends JpaRepository<Company, Long>
{
    Optional<Company> findByEmail(String email);
}
