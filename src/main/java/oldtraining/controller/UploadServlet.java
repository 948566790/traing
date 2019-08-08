package oldtraining.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 上传文件
 */
@WebServlet(name = "UploadServlet", urlPatterns = "/upload")
public class UploadServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        DiskFileItemFactory dff = new DiskFileItemFactory();
        dff.setSizeThreshold(1024 * 102400);
        dff.setRepository(new File("F/cache"));
        ServletFileUpload upload = new ServletFileUpload(dff);
        upload.setFileSizeMax(1024 * 1024);
        upload.setSizeMax(1024 * 1024);
        String path = request.getServletContext().getRealPath("/");
        try {
            List<FileItem> files = upload.parseRequest(request);
            for (FileItem f : files) {
                if (!f.isFormField()) {
                    String fileName = f.getName();
                    f.write(new File(path + "upload/" + fileName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.getWriter().write("上传成功");
    }


}
