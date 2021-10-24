package com.cyquen.facedetector.controller;

import com.cyquen.facedetector.service.FaceDetectorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class FaceDetectorController {

    FaceDetectorService faceDetectorService;

    public FaceDetectorController(FaceDetectorService faceDetectorService) {
        this.faceDetectorService = faceDetectorService;
    }

    @PostMapping("/face/detector")
    public void faceDetector(HttpServletResponse response, MultipartFile file) throws IOException {
        faceDetectorService.detect(response, file);
    }
}
