package com.example.springbootblog.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.example.springbootblog.controller.dto.LoginDTO;
import com.example.springbootblog.controller.request.LoginRequest;
import com.example.springbootblog.entity.Admin;
import com.example.springbootblog.exception.ServiceException;
import com.example.springbootblog.mapper.AdminMapper;
import com.example.springbootblog.service.IAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class Adminservice implements IAdminService {
    private static final String DEFAULT_SALT="cctv";
    @Autowired
    AdminMapper adminMapper;
    @Override
    public void register(Admin admin) {
        admin.setPassword(secure(admin.getPassword()));
        admin.setCover("1688977880042.jpg");
        try {
            adminMapper.register(admin);
        }catch (DuplicateKeyException e){
            throw new ServiceException("用户已存在");
        }
    }

    @Override
    public LoginDTO login(LoginRequest loginRequest) {
        loginRequest.setPassword(secure(loginRequest.getPassword()));
        Admin admin=adminMapper.login(loginRequest);
        if (admin == null) {
            throw new ServiceException("用户名或密码错误");
        }
        LoginDTO login = new LoginDTO();
        BeanUtils.copyProperties(admin,login);
        return login;
    }

    @Override
    public void updatePass(Admin admin) {
        adminMapper.updatePass(admin);
    }

    @Override
    public LoginDTO adminByIdList(Integer id) {
        Admin admin=adminMapper.adminByIdList(id);
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(admin,loginDTO);
        return loginDTO;
    }

    @Override
    public void update(Admin admin) {
        adminMapper.update(admin);
    }

    private String secure(String password){
        return SecureUtil.md5(password+DEFAULT_SALT);

    }

}
