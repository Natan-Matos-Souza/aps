package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "reports")
public class Report
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;
}
