package com.example.springbootblog.controller;

import com.example.springbootblog.common.Result;
import com.example.springbootblog.controller.dto.LoginDTO;
import com.example.springbootblog.controller.request.LoginRequest;
import com.example.springbootblog.entity.Admin;
import com.example.springbootblog.service.impl.Adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    Adminservice adminservice;
    @PostMapping("/register")
    public Result register(@RequestBody Admin admin){
        adminservice.register(admin);
        return Result.success();
    }
    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest){
        LoginDTO login=adminservice.login(loginRequest);
        return Result.success(login);
    }
}
