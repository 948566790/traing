package com.ming.springbootdemo.dao;

import com.ming.springbootdemo.pojo.Orderdetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jzm
 * @package com.ming.springbootdemo.dao
 * @date 2019/9/9 0009 11:03
 */

@Mapper
public interface OrderDetailMapper {
    /**
     * 添加订单详情
     * @param orderdetail 订单详情对象
     * @return
     */
    int addOrderDetail(Orderdetail orderdetail);
}
