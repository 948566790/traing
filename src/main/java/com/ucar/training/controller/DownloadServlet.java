package com.ucar.training.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * 下载文件
 */
@WebServlet(name = "DownloadServlet", urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        //获取请求数据
        String filename = req.getParameter("filename");
        System.out.println(filename);
        //设置响应头，使链接可下载
        resp.setContentType(getServletContext().getMimeType(filename));
        resp.setHeader("Content-Disposition", "attachment;filename=" + filename);
        //获取下载文件的路径
        String downPath = this.getServletContext().getRealPath("/download/" + filename);
        //通过io流实现文件传输
        FileInputStream fis = new FileInputStream(new File(downPath));
        ServletOutputStream os = resp.getOutputStream();
        byte[] datas = new byte[1024 * 1024];
        while (fis.read(datas) > 0) {
            os.write(datas);
            os.flush();
        }
        os.close();
        fis.close();
    }
}
