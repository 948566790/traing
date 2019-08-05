package com.ucar.training.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encode;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        resp.setCharacterEncoding(encode);
        req.setCharacterEncoding(encode);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        encode = config.getInitParameter("encode");
    }

}
