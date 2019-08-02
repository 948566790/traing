package com.ucar.training.Servlet;

import com.ucar.training.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

@WebServlet(name = "CheckUnameServlet", urlPatterns = "/checkname")
public class CheckUnameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取请求数据
        String uname = request.getParameter("userName");
        //处理
        PrintWriter out = response.getWriter();
        Set<User> users = (Set<User>) this.getServletContext().getAttribute("users");
        if (users != null) {
            for (User u : users) {
                if (u.getUname().equals(uname)) {
                    out.print(true);
                    break;
                }
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
