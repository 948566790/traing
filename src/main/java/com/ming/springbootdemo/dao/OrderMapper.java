package com.ming.springbootdemo.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author jzm
 * @package com.ming.springbootdemo.dao
 * @date 2019/9/9 0009 10:00
 */

@Mapper
public interface OrderMapper {
    /**
     * 生成订单
     * @param totalPrice 总价
     * @param uid 用户id
     * @param orderNum 随机生成的订单编号
     * @return
     */
    int addOrder(int totalPrice,long uid,String orderNum);
}
