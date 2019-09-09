package com.ming.springbootdemo;

import com.ming.springbootdemo.dao.GoodsMapper;
import com.ming.springbootdemo.dao.ShoppingcartMapper;
import com.ming.springbootdemo.pojo.Shoppingcart;
import com.ming.springbootdemo.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {

    @Resource
    private GoodsMapper goodsMapper;

    @Resource
    private ShoppingcartMapper shoppingcartMapper;

    @Resource
    private GoodsService goodsServiceImpl;
    @Test
    public void contextLoads() {
        String s = UUID.randomUUID().toString();
        System.out.println(s);

    }

}
