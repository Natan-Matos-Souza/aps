package com.example.demo.services;

import com.example.demo.dto.ReportDto;
import com.example.demo.models.Report;

import java.util.List;

public interface ReportServiceInterface
{
    public void create(ReportDto reportDto);
    public List<Report> getReportsFromUser(Long userId);
}
