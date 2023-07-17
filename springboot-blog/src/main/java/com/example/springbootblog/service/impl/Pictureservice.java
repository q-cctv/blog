package com.example.springbootblog.service.impl;
import com.example.springbootblog.entity.Picture;
import com.example.springbootblog.mapper.PictureMapper;
import com.example.springbootblog.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Pictureservice implements IPictureService {

    @Autowired
    PictureMapper pictureMapper;

    @Override
    public void update(Picture obj) {
        pictureMapper.update(obj);
    }


    @Override
    public void delUser(Integer id) {
        pictureMapper.delUser(id);
    }

    @Override
    public void add(Picture obj) {
        pictureMapper.add(obj);
    }

    @Override
    public List<Picture> list() {
       List<Picture> pictures= pictureMapper.list();
       return  pictures;
    }

}
