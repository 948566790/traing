package com.ming.springbootdemo.service.impl;

import com.ming.springbootdemo.dao.OrderDetailMapper;
import com.ming.springbootdemo.pojo.Orderdetail;
import com.ming.springbootdemo.service.OrderDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author jzm
 * @package com.ming.springbootdemo.service.impl
 * @date 2019/9/9 0009 11:12
 */

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Resource
    private OrderDetailMapper orderDetailMapper;

    @Override
    public int addOrderDetailService(Orderdetail orderdetail) {
        return orderDetailMapper.addOrderDetail(orderdetail);
    }
}
