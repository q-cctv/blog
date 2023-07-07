package com.example.springbootblog.entity;

import lombok.Data;

@Data
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private Integer phone;
    private String address;
    private String email;
}
