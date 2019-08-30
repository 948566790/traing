package com.ucar.training.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {
    @RequestMapping("download")
    public void download(String filename, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Content-Disposition", "attachment;filename=" + filename);
        ServletOutputStream os = response.getOutputStream();
        byte[] bytes = FileUtils.readFileToByteArray(new File(("E:/java_idea/train_group3/src/main/webapp/download/") + filename));
        os.write(bytes);
        os.flush();
        os.close();
    }

    @RequestMapping("upload")
    public void upload(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filename = file.getOriginalFilename();
        String stuffix = filename.substring(filename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        System.out.println(stuffix + uuid);
        FileUtils.copyInputStreamToFile(file.getInputStream(), new File(("E:/java_idea/train_group3/src/main/webapp/upload/") + uuid + stuffix));
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("上传成功。。。。");
    }

}
