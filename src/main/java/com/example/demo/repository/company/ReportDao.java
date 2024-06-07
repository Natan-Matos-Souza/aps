package com.example.demo.repository.company;

import com.example.demo.models.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportDao extends JpaRepository<Report, Integer> {
    
}
