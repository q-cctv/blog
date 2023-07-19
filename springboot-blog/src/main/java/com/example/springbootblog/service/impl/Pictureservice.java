package com.example.springbootblog.service.impl;
import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.example.springbootblog.entity.Picture;
import com.example.springbootblog.mapper.PictureMapper;
import com.example.springbootblog.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class Pictureservice implements IPictureService {

    @Autowired
    PictureMapper pictureMapper;

    private static final String REDIS_KEY="REDIS_KEY_YY";

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void update(Picture obj) {
        pictureMapper.update(obj);
        stringRedisTemplate.delete(REDIS_KEY);
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

    @Override
    public List<Picture> listStatus() {

        String jsonStr=stringRedisTemplate.opsForValue().get(REDIS_KEY);
        if(StrUtil.isBlank(jsonStr)){
            List<Picture> pictures= pictureMapper.listStatus();
            List<Picture> list=new ArrayList<>();
            for(Picture picture: pictures){
                if(picture.isStatus()){
                    list.add(picture);
                }
            }
            stringRedisTemplate.opsForValue().set(REDIS_KEY, JSONUtil.toJsonStr(list));
            return list;
        } else {
            List<Picture> pictures=JSONUtil.toBean(jsonStr, new TypeReference<List<Picture>>() {
            },true);
            return pictures;
        }

    }

}
