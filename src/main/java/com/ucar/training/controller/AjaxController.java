package com.ucar.training.controller;

import com.ucar.training.domain.User;
import com.ucar.training.service.UserService;
import com.ucar.training.service.impl.UserServiceImpl;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

/**
 * Ajax用来检查是否存在重名
 */
@Controller
public class AjaxController {
    @Resource
    private UserService userServiceImpl;

    @RequestMapping("check")
    public void ajax(String uname, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        User user = userServiceImpl.getUserInfoService(uname);
        if (user == null) {
            out.print("true");
        } else {
            out.print("false");
        }
    }
}
