package com.example.springbootblog.controller;

import com.example.springbootblog.common.Result;
import com.example.springbootblog.entity.Picture;
import com.example.springbootblog.service.impl.Pictureservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    Pictureservice pictureservice;
    @GetMapping("/list")
    public Result list(){
       List<Picture> picture= pictureservice.list();
        return Result.success(picture);
    }
    @GetMapping("/listStatus")
    public Result listStatus(){
        List<Picture> picture= pictureservice.listStatus();
        return Result.success(picture);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Picture obj){
        pictureservice.add(obj);
        return Result.success();
    }
    @PutMapping("/update")
    public Result update(@RequestBody Picture obj){
        pictureservice.update(obj);
        return Result.success();
    }
    @DeleteMapping("/delete/{id}")
    public Result delUser(@PathVariable Integer id){
        pictureservice.delUser(id);
        return Result.success();
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
