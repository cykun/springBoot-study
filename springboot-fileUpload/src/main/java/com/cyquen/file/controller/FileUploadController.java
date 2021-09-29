package com.cyquen.file.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author zheng
 */
@RestController
public class FileUploadController {

    @Value("${file.upload-path}")
    public String filePath;

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Upload fail! please choose a file";
        }
        String fileName = file.getOriginalFilename();
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            return "Upload succeed!, filepath: " + dest.getAbsolutePath();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
