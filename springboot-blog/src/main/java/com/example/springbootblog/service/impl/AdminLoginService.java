package com.example.springbootblog.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.example.springbootblog.controller.dto.LoginDTO;
import com.example.springbootblog.controller.request.LoginRequest;
import com.example.springbootblog.entity.Admin;
import com.example.springbootblog.entity.AdminLogin;
import com.example.springbootblog.exception.ServiceException;
import com.example.springbootblog.mapper.AdminLoginMapper;
import com.example.springbootblog.mapper.AdminMapper;
import com.example.springbootblog.service.IAdminLoginService;
import com.example.springbootblog.service.IAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginService implements IAdminLoginService {
    @Autowired
    AdminLoginMapper adminLoginMapper;

    private static final String DEFAULT_SALT="cctv";
    private String secure(String password){
        return SecureUtil.md5(password+DEFAULT_SALT);

    }
    @Override
    public void register(AdminLogin adminLogin) {
        adminLogin.setPassword(secure(adminLogin.getPassword()));
        adminLogin.setCover("1688977880042.jpg");
        try {
            adminLoginMapper.register(adminLogin);
        }catch (DuplicateKeyException e){
            throw new ServiceException("用户已存在");
        }
    }

    @Override
    public LoginDTO login(LoginRequest loginRequest) {
        loginRequest.setPassword(secure(loginRequest.getPassword()));
        AdminLogin adminLogin=adminLoginMapper.login(loginRequest);
        if (adminLogin == null) {
            throw new ServiceException("用户名或密码错误");
        }
        LoginDTO login = new LoginDTO();
        BeanUtils.copyProperties(adminLogin,login);
        return login;
    }


    @Override
    public void updatePass(AdminLogin adminLogin) {
        adminLoginMapper.updatePass(adminLogin);
    }

    @Override
    public LoginDTO adminByIdList(Integer id) {
        AdminLogin adminLogin=adminLoginMapper.adminByIdList(id);
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(adminLogin,loginDTO);
        return loginDTO;
    }

    @Override
    public void update(AdminLogin adminLogin) {
        adminLoginMapper.update(adminLogin);
    }

}
