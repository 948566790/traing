package com.ming.springbootdemo.config;

import com.ming.springbootdemo.interceptor.LoginInterceptor;
import com.ming.springbootdemo.interceptor.PushInterceptor;
import com.ming.springbootdemo.interceptor.addGoodsToCartInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jzm
 * @package com.ming.springbootdemo.config
 * @date 2019/9/7 0007 22:31
 */

@Component
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {
    @Autowired
    private addGoodsToCartInterceptor add;

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Autowired
    private PushInterceptor pushInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(add).addPathPatterns("/addGoodsToCart");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/goods2");
        registry.addInterceptor(pushInterceptor).addPathPatterns("/push");
    }
}
