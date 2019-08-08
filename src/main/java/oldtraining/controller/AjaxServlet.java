package oldtraining.controller;

import oldtraining.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * Ajax用来检查是否存在重名
 */
@WebServlet(name = "AjaxServlet", urlPatterns = "/checkname")
public class AjaxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
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
        } else {
            out.print(false);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
