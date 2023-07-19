package com.example.springbootblog.controller;

import com.example.springbootblog.common.Result;
import com.example.springbootblog.controller.request.LoginRequest;
import com.example.springbootblog.entity.AdminLogin;
import com.example.springbootblog.service.impl.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@CrossOrigin
@RequestMapping("/adminLogin")
public class AdminLoginController {
    @Autowired
    AdminLoginService adminLoginservice;
    @PostMapping("/register")
    public Result register(@RequestBody AdminLogin adminLogin){
        adminLoginservice.register(adminLogin);
        return Result.success();
    }
    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest){

        return Result.success(adminLoginservice.login(loginRequest));
    }
    @PutMapping("/update")
    public Result update(@RequestBody AdminLogin adminLogin){
        adminLoginservice.update(adminLogin);
        return Result.success();
    }
    @PutMapping("/updatePass")
    public Result updatePass(@RequestBody AdminLogin adminLogin){
        adminLoginservice.updatePass(adminLogin);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result adminByIdList(@PathVariable Integer id){

        return Result.success(adminLoginservice.adminByIdList(id));
    }

    @PostMapping("/upload")
    public Result upload(MultipartFile file){
        if(file.isEmpty()){
            return Result.error("文件为空");
        }
        long time=System.currentTimeMillis();
        String OriginalFileName=file.getOriginalFilename();
        String fileName=time+"."+OriginalFileName.substring(OriginalFileName.lastIndexOf(".")+1);
        String url="C:\\Users\\Administrator\\Desktop\\blog\\vue\\src\\assets\\img\\";
        File file1 = new File(url+fileName);
        if(!file1.getParentFile().exists()){
            file1.getParentFile().exists();
        }
        try {
            file.transferTo(file1);
            return Result.success(fileName);
        }catch (Exception e){
            return Result.error("上传失败");
        }
    }
}