package com.example.springbootblog.mapper;

import com.example.springbootblog.controller.request.LoginRequest;
import com.example.springbootblog.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    void register(Admin admin);

    Admin login(LoginRequest loginRequest);

    void updatePass(Admin admin);

    Admin adminByIdList(Integer id);

    void update(Admin admin);
//    int adminByUserName(Admin admin);

}
