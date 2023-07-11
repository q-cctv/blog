package com.example.springbootblog.service;

import com.example.springbootblog.controller.dto.LoginDTO;
import com.example.springbootblog.controller.request.LoginRequest;
import com.example.springbootblog.entity.Admin;
import com.example.springbootblog.entity.AdminLogin;

public interface IAdminLoginService {

    void register(AdminLogin adminLogin);

    LoginDTO login(LoginRequest loginRequest);

    void updatePass(AdminLogin adminLogin);

    LoginDTO adminByIdList(Integer id);

    void update(AdminLogin adminLogin);
//
//    void adminByUserName(Admin admin);

}
