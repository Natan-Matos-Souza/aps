package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class LoginDto
{
    private String companyEmail;
    private String password;
}
