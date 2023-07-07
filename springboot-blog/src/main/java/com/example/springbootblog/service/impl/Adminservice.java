package com.example.springbootblog.service.impl;

import com.example.springbootblog.controller.dto.LoginDTO;
import com.example.springbootblog.controller.request.LoginRequest;
import com.example.springbootblog.entity.Admin;
import com.example.springbootblog.mapper.AdminMapper;
import com.example.springbootblog.service.IAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Adminservice implements IAdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public void register(Admin admin) {
        adminMapper.register(admin);
    }

    @Override
    public LoginDTO login(LoginRequest loginRequest) {

        Admin admin1=adminMapper.login(loginRequest);
        LoginDTO login = new LoginDTO();
        BeanUtils.copyProperties(admin1,login);
        return login;
    }
}
