package com.example.springbootblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Admin {
    private Integer id;
    private String username;
    private String password;
    private Integer phone;
    private String address;
    private String email;
    private String newPass;
    private String cover;
    private boolean status;
}
