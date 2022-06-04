package com.zkh.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author zkh
 * @date 2022/6/4 -16:13
 */
@Slf4j
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }


    //MultipartFile自动封装上传过来的文件
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImage") MultipartFile headerImage,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("数据为:email={},username={},headerImage={},photos={}",email,username,headerImage,photos);

        if (!headerImage.isEmpty()){
            String originalFilename = headerImage.getOriginalFilename();
            headerImage.transferTo(new File("E:\\file_test\\"+originalFilename));
        }

        if (photos.length>0){
            for (MultipartFile photo : photos){
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\file_test\\"+originalFilename));
                }
            }
        }
        return "main";
    }

}
