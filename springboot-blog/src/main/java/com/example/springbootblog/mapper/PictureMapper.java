package com.example.springbootblog.mapper;

import com.example.springbootblog.controller.request.LoginRequest;
import com.example.springbootblog.entity.Admin;
import com.example.springbootblog.entity.Picture;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PictureMapper {


    void update(Picture obj);

    void delUser(Integer id);

    void add(Picture obj);

    List<Picture> list();



//    int adminByUserName(Admin admin);

}
