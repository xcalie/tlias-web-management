package com.xc.tlias_web_management.controller;

import com.xc.tlias_web_management.pojo.Result;
import com.xc.tlias_web_management.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class UploadController {

    @Autowired
    AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException{
        log.info("上传文件: {}", image.getOriginalFilename());

        String url = aliOSSUtils.upload(image);
        log.info("上传成功，文件地址: {}", url);

        return Result.success(url);
    }

    /*@PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile imgae) {
        log.info("上传文件: {}, 用户名: {}, 年龄: {}", imgae.getOriginalFilename(), username, age);

        // 调用MultipartFile的transferTo方法将文件保存到本地
        String originalFilename = imgae.getOriginalFilename();

        // 构造唯一文件名 uuid 通用唯一标识符
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        String uuid = UUID.randomUUID().toString() + suffix;

        // 保存文件
        try {
            imgae.transferTo(new File("D:/images/" + originalFilename));
        } catch (IOException e) {
            log.error("保存文件失败", e);
            return Result.error("保存文件失败");
        }

        return Result.success();
    }*/
}
