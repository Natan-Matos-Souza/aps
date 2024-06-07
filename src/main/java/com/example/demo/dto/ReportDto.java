package com.example.demo.dto;

import lombok.*;

import java.time.format.DateTimeFormatter;


@Builder
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto
{
    private String description;
    private Long polutionRegistered;
}
