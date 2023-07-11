package com.example.springbootblog.mapper;

import com.example.springbootblog.controller.request.LoginRequest;
import com.example.springbootblog.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    void register(Admin admin);

    Admin login(LoginRequest loginRequest);

    void updatePass(Admin admin);

    Admin adminByIdList(Integer id);

    void update(Admin admin);

    List<Admin> getAll();

    void delUser(Integer id);




//    int adminByUserName(Admin admin);

}
