package com.example.springbootblog.controller.request;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
