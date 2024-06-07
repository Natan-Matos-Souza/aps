package com.example.demo.services.impl;

import com.example.demo.dto.ReportDto;
import com.example.demo.models.Report;
import com.example.demo.repository.company.ReportDao;
import com.example.demo.services.ReportServiceInterface;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService implements ReportServiceInterface
{
    private HttpSession session;
    private ReportDao repository;

    @Autowired
    public ReportService(HttpSession session, ReportDao repository) {
        this.session = session;
        this.repository = repository;
    }

    @Override
    public void create(ReportDto reportDto)
    {
        Report report = new Report();
        report.setPolutionPerMonth(reportDto.getPolutionRegistered());
        report.setCompanyId((Long) session.getAttribute("companyId"));
        report.setDescription(reportDto.getDescription());
        this.repository.save(report);
    }

    @Override
    public List<Report> getReportsFromUser(Long userId) {
        return List.of();
    }
}
