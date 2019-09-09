package com.ming.springbootdemo.service;

import com.ming.springbootdemo.pojo.Goods;

import java.util.List;

public interface GoodsService {
    /**
     * 根据商品id获取商品信息
     *
     * @param id 商品id
     * @return 商品对象
     */
    Goods selByIdService(String id);

    /**
     * 根据商品名称获取商品信息
     *
     * @param name 商品名称
     * @return 商品对想
     */
    Goods selByNameService(String name);

    /**
     * 获取所有商品
     *
     * @return 商品列表
     */
    List<Goods> selAllGooodsService();

    /**
     * 减少库存
     *
     * @param goodsId 商品id
     * @param reduce  减少量
     * @return 更新行数
     */
    int reduceStockService(String goodsId, long reduce);

    /**
     * 根据输入返回对应种类的商品
     *
     * @param word 输入的文字
     * @return 对应种类的商品队列
     */
    List<Goods> searchService(String word);
}
