package com.ucar.training.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 侮辱词汇过滤器：
 * 过滤所有侮辱词汇，将其替换为**。
 */

public class DirtyFilter implements Filter {
    private String[] dirtyList;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //获取请求数据
        String msg = req.getParameter("message");
        String name = req.getParameter("uname");
        //替换侮辱词汇
        for (String dirt : dirtyList) {
            System.out.println("dirt-->" + dirt);
            msg = msg.replace(dirt, "*");
        }
        //请求转发
        req.getRequestDispatcher("/mg?uname=" + name + "&message=" + msg).forward(req, resp);
        return;


    }

    public void init(FilterConfig config) throws ServletException {
        dirtyList = config.getInitParameter("dirtylist").split(",");
    }

}
