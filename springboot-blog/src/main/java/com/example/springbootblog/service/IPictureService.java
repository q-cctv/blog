package com.example.springbootblog.service;

import com.example.springbootblog.controller.dto.LoginDTO;
import com.example.springbootblog.controller.request.LoginRequest;
import com.example.springbootblog.entity.Admin;
import com.example.springbootblog.entity.Picture;

import java.util.List;

public interface IPictureService {




    void update(Picture obj);


    void delUser(Integer id);

    void add(Picture obj);

    List<Picture> list();



//
//    void adminByUserName(Admin admin);

}
