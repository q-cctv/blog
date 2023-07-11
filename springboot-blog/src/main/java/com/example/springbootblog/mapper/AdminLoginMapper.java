package com.example.springbootblog.mapper;

import com.example.springbootblog.controller.request.LoginRequest;
import com.example.springbootblog.entity.Admin;
import com.example.springbootblog.entity.AdminLogin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminLoginMapper {
    void register(AdminLogin adminLogin);

    AdminLogin login(LoginRequest loginRequest);

    void updatePass(AdminLogin adminLogin);

    AdminLogin adminByIdList(Integer id);

    void update(AdminLogin adminLogin);
//    int adminByUserName(Admin admin);

}
