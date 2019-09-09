package com.ming.springbootdemo.service.impl;

import com.ming.springbootdemo.dao.OrderMapper;
import com.ming.springbootdemo.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jzm
 * @package com.ming.springbootdemo.service.impl
 * @date 2019/9/9 0009 10:20
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Override
    public int addOrderService(int totalPrice, long uid, String orderNum) {
        return orderMapper.addOrder(totalPrice, uid,orderNum);
    }
}
