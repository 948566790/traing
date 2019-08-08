package com.ucar.training.filter;

import com.ucar.training.domain.RootUser;
import com.ucar.training.service.impl.RootUserServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤超级用户：
 * 当登陆用户为超级用户时，将登陆网页跳转到超级用户界面。
 */
@WebFilter(filterName = "RootUserFilter", urlPatterns = "/login")
public class RootUserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        HttpServletResponse response = (HttpServletResponse) resp;
        //创建业务层对象对超级用户登陆检查
        RootUserServiceImpl rus = new RootUserServiceImpl();
        RootUser root = rus.rootCheckPwdService(req.getParameter("uname"), req.getParameter("pwd"));
        if (root != null) {//超级用户登陆成功
            req.setAttribute("rootname", root.getRuname());
            response.sendRedirect("pages/root/rootlogin.jsp");
            return;
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
