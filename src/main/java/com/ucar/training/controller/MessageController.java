package com.ucar.training.controller;

import com.ucar.training.domain.Message;
import com.ucar.training.domain.User;
import com.ucar.training.service.MenuService;
import com.ucar.training.service.MessageService;
import com.ucar.training.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MessageController {
    @Resource
    private MessageService messageServiceImpl;

    @Resource
    private MenuService menuServiceImpl;

    @Resource
    private UserService userServiceImpl;

    @RequestMapping("usermsg/{uname}")
    public String userMsg(@PathVariable String uname, HttpServletRequest request) {
        User user = userServiceImpl.getUserInfoService(uname);
        request.setAttribute("menus", menuServiceImpl.selMenuByIdService(user.getRoleId()));
        return "usermsg";
    }

    @RequestMapping("msghistory/{uname}")
    public String msgHistory(@PathVariable String uname, HttpServletRequest request) {
        User user = userServiceImpl.getUserInfoService(uname);
        request.setAttribute("menus", menuServiceImpl.selMenuByIdService(user.getRoleId()));
        request.setAttribute("umessages", messageServiceImpl.getUserMsgService(uname));
        return "msghistory";
    }

    @RequestMapping("managemsg/{uname}")
    public String manageMsg(@PathVariable String uname, HttpServletRequest request) {
        User user = userServiceImpl.getUserInfoService(uname);
        request.setAttribute("menus", menuServiceImpl.selMenuByIdService(user.getRoleId()));
        request.setAttribute("allmessages", messageServiceImpl.getAllMsgService());
        return "managemsg";
    }

    @RequestMapping("addmsg")
    public String addMsg(Message message, HttpServletRequest request) {
        messageServiceImpl.saveMsgService(message.getUname(), message.getMsg());
        return "forward:/usermsg/" + request.getSession().getAttribute("username");
    }

    @RequestMapping("delmsg/{uname}/{time}")
    public String delMsg(@PathVariable String uname, @PathVariable String time, HttpServletRequest request) {
        messageServiceImpl.msgDelService(uname, time);
        return "forward:/managemsg/" + request.getSession().getAttribute("username");
    }
}
