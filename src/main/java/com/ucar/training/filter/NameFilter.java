package com.ucar.training.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class NameFilter implements Filter {
    private String[] blacklist;

    public void destroy() {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String uname = req.getParameter("uname");
        if (uname != null) {
            for (String bn : blacklist) {
                if (bn.equals(uname)) {
                    resp.getWriter().write("<html>");
                    resp.getWriter().write("<body>");
                    resp.getWriter().write("<h1>");
                    resp.getWriter().write("对不起，你已被拉入黑名单");
                    resp.getWriter().write("</h1>");
                    resp.getWriter().write("</body>");
                    resp.getWriter().write("</html>");
                    return;
                }
            }
        }
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {
        this.blacklist = config.getInitParameter("blacklist").split(",");
    }

}
