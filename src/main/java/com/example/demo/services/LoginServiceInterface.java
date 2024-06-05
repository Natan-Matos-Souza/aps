package com.example.demo.services;

import com.example.demo.dto.LoginDto;

public interface LoginServiceInterface
{
    boolean auth(LoginDto credentials);
    boolean isAuthenticated();
}
