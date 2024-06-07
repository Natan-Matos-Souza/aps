package com.example.demo.repository.company;

import com.example.demo.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportDao extends JpaRepository<Report, Integer> {
    List<Report> findByCompanyId(Long companyId);
}
