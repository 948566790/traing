package com.ucar.training.controller;

import com.ucar.training.domain.User;
import com.ucar.training.service.UserService;
import com.ucar.training.service.impl.UserServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 修改用户信息（仅超级用户可用）
 */
@WebServlet(name = "ChangeInfoServlet", urlPatterns = "/save")
public class ChangeInfoServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = context.getBean("userService", UserService.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求数据
        String uname = req.getParameter("uname");
        String age = req.getParameter("age");
        String sex = req.getParameter("sex");
        String tel = req.getParameter("tel");
        String email = req.getParameter("mail");
        String sign = req.getParameter("sign");
        String[] favs = req.getParameterValues("fav");
        //处理
        String fav = Arrays.toString(favs).replaceAll("[\\[\\]]", "");
        //获取用户对象
        User u = userService.getUserInfoService(uname);
        if (u != null) {
            u.setAge(age);
            u.setSex(sex);
            u.setTel(tel);
            u.setEmail(email);
            u.setFav(fav);
            u.setSign(sign);
        }
        System.out.println("save u -->" + u);
        //修改信息
        userService.userChangeService(u);
        req.getSession().setAttribute("users", userService.getUSersService());
        resp.sendRedirect("pages/root/rootlogin.jsp");
        return;
    }
}
