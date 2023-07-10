package com.example.springbootblog.service;

import com.example.springbootblog.controller.dto.LoginDTO;
import com.example.springbootblog.controller.request.LoginRequest;
import com.example.springbootblog.entity.Admin;

public interface IAdminService {

    void register(Admin admin);

    LoginDTO login(LoginRequest loginRequest);

    void updatePass(Admin admin);

    LoginDTO adminByIdList(Integer id);

    void update(Admin admin);
//
//    void adminByUserName(Admin admin);

}
