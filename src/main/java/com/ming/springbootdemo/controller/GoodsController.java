package com.ming.springbootdemo.controller;

import com.ming.springbootdemo.pojo.Goods;
import com.ming.springbootdemo.service.GoodsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class GoodsController {
    @Resource
    private GoodsService goodsServiceImpl;

    @RequestMapping("/goods")
    public String goods() {
        return "goods";
    }

    @RequestMapping("/goods2")
    public String goods2() {
        return "goods";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/selAllGoods")
    @ResponseBody
    public List<Goods> selAllGoods() {
        return goodsServiceImpl.selAllGooodsService();
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<Goods> search(String word) {
        return goodsServiceImpl.searchService(word);
    }


    @RequestMapping("")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/goods");
        return modelAndView;
    }

}
