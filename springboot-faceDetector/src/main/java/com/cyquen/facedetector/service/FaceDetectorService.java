package com.cyquen.facedetector.service;

import org.apache.commons.io.FileUtils;
import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class FaceDetectorService {

    private static final Logger log = LoggerFactory.getLogger(FaceDetectorService.class);

    @Value("classpath:haarcascade_frontalface_alt.xml")
    private Resource xml;

    private String targetXmlFileUri;

    @PostConstruct
    public void postConstruct() throws IOException {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        File targetXmlFile = new File("src/" + xml.getFilename() + "");
        FileUtils.copyInputStreamToFile(xml.getInputStream(), targetXmlFile);
        targetXmlFileUri = targetXmlFile.getPath();
    }

    public void detect(HttpServletResponse response, MultipartFile file) throws IOException {
        CascadeClassifier faceDetector = new CascadeClassifier(targetXmlFileUri);
        if (faceDetector.empty()) {
            log.info("请引入文件……");
            return;
        }
        File tempFile = new File("src/" + file.getOriginalFilename() + "");
        FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);
        Mat image = Imgcodecs.imread(tempFile.toString());
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        Rect[] rects = faceDetections.toArray();
        if(rects.length == 0) {
            response.getWriter().write("we cannot detector any faces");
            return;
        }
        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0), 3);
        }
        Imgcodecs.imwrite(tempFile.getPath(), image);
        if (tempFile.exists()) {
            response.getOutputStream().write(toByteArray(tempFile));
            response.getOutputStream().close();
        }
        // FileUtils.de(tempFile);
    }

    private static byte[] toByteArray(File file) throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("file not exists");
        }
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream((int) file.length())) {
            BufferedInputStream in;
            in = new BufferedInputStream(new FileInputStream(file));
            int buf_size = 1024;
            byte[] buffer = new byte[buf_size];
            int len;
            while (-1 != (len = in.read(buffer, 0, buf_size))) {
                bos.write(buffer, 0, len);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
