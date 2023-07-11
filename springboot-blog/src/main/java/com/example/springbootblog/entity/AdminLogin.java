package com.example.springbootblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AdminLogin {
    private Integer id;
    private String username;
    private String password;
    private Integer phone;
    private String address;
    private String email;
    private String newPass;
    private String cover;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDate createTime;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDate updateTime;
}
