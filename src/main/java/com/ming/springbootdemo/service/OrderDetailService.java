package com.ming.springbootdemo.service;

import com.ming.springbootdemo.pojo.Orderdetail;

/**
 * @author jzm
 * @package com.ming.springbootdemo.service
 * @date 2019/9/9 0009 11:11
 */
public interface OrderDetailService {
    /**
     * 添加订单详情
     * @param orderdetail 订单详情对象
     * @return
     */
    int addOrderDetailService(Orderdetail orderdetail);
}
