package com.example.springbootblog.controller;

import com.example.springbootblog.common.Result;
import com.example.springbootblog.controller.dto.LoginDTO;
import com.example.springbootblog.controller.request.LoginRequest;
import com.example.springbootblog.entity.Admin;
import com.example.springbootblog.service.impl.Adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    Adminservice adminservice;
    @GetMapping("/getAll")
    public Result getAll(){
        List<Admin> admin=adminservice.getAll();
        return Result.success(admin);
    }
    @PostMapping("/register")
    public Result register(@RequestBody Admin admin){
        adminservice.register(admin);
        return Result.success();
    }
    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest){

        return Result.success(adminservice.login(loginRequest));
    }
    @PutMapping("/update")
    public Result update(@RequestBody Admin admin){
        adminservice.update(admin);
        return Result.success();
    }
    @DeleteMapping("/delete/{id}")
    public Result delUser(@PathVariable Integer id){
        adminservice.delUser(id);
        return Result.success();
    }
    @PutMapping("/updatePass")
    public Result updatePass(@RequestBody Admin admin){
        adminservice.updatePass(admin);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result adminByIdList(@PathVariable Integer id){

        return Result.success(adminservice.adminByIdList(id));
    }

    @PostMapping("/upload")
    public Result upload(MultipartFile file){
        if(file.isEmpty()){
            return Result.error("文件为空");
        }
        long time=System.currentTimeMillis();
        String OriginalFileName=file.getOriginalFilename();
        String fileName=time+"."+OriginalFileName.substring(OriginalFileName.lastIndexOf(".")+1);
//        String url="C:\\Users\\Administrator\\Desktop\\blog\\vue\\src\\assets\\img\\";
        String url="C:\\Users\\Administrator\\Desktop\\blog\\upload\\";
        File file1 = new File(url+fileName);
        if(!file1.getParentFile().exists()){
            file1.getParentFile().exists();
        }
        try {
            file.transferTo(file1);
            return Result.success("http://localhost:9090/upload/"+fileName);
//            return Result.success(fileName);

        }catch (Exception e){
            return Result.error("上传失败");
        }
    }
}
