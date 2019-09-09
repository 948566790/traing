package com.ming.springbootdemo.interceptor;

import com.ming.springbootdemo.pojo.Goods;
import com.ming.springbootdemo.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class addGoodsToCartInterceptor implements HandlerInterceptor {
    @Autowired
    private GoodsService goodsServiceImpl;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String goodsId = request.getParameter("goodsId");
        Goods goods = goodsServiceImpl.selByIdService(goodsId);
        if (goods.getStock() <= 0) {
            response.setContentType("text/html;charset=utf8");
            response.getWriter().write("<script language='javascript'>alert('库存不足！！！');window.location.href='/goods';</script>");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
