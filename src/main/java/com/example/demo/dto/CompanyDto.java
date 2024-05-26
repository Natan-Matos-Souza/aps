package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDto
{
    private Long id;
    private String companyName;
}
