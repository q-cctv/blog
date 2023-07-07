package com.example.springbootblog.controller.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private Integer id;
    private String username;
    private Integer phone;
    private String address;
    private String email;
}
