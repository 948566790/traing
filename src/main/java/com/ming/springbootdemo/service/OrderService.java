package com.ming.springbootdemo.service;

/**
 * @author jzm
 * @package com.ming.springbootdemo.service
 * @date 2019/9/9 0009 10:19
 */
public interface OrderService {
    /**
     * 生成订单
     * @param totalPrice 总价
     * @param uid 用户id
     * @param orderNum 随机生成的订单编号
     * @return
     */
    int addOrderService(int totalPrice,long uid,String orderNum);
}
