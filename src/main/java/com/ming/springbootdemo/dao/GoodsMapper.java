package com.ming.springbootdemo.dao;

import com.ming.springbootdemo.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface GoodsMapper {
    /**
     * 根据商品id获取商品信息
     *
     * @param id 商品id
     * @return 商品对象
     */
    Goods selById(String id);

    /**
     * 根据商品名称获取商品信息
     *
     * @param name 商品名称
     * @return 商品对想
     */
    Goods selByName(String name);

    /**
     * 获取所有商品
     *
     * @return 商品列表
     */
    List<Goods> selAllGoods();

    /**
     * 减少库存
     *
     * @param goodsId 商品id
     * @param reduce  减少量
     * @return 更新行数
     */
    int reduceStock(String goodsId, long reduce);

    /**
     * 根据输入返回对应种类的商品
     *
     * @param word 输入的文字
     * @return 对应种类的商品队列
     */
    List<Goods> search(String word);
}
