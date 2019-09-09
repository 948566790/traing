package com.ming.springbootdemo.service;

import com.ming.springbootdemo.pojo.Shoppingcart;

import java.util.List;

public interface ShoppingcartService {

    /**
     * 购物车添加商品
     *
     * @param goodsId 商品id
     * @param uid 用户id
     * @return 更新行数
     */
    int addGoodsToCartService(String goodsId, long uid);

    /**
     * 购物添加商品 （用户未登录）
     * @param goodsId 商品id
     * @param sessionId sessionId
     * @return 更新行数
     */
    int addGoodsToCartBySidService(String goodsId, String sessionId);

    /**
     * 更新购物车中的商品信息（改变商品数量）(已登录)
     *
     * @param shoppingcart 商品对象
     * @return 更新行数
     */
    int updCartService(Shoppingcart shoppingcart);

    /**
     * 更新购物车中的商品信息（改变商品数量）(未登录)
     *
     * @param shoppingcart 商品对象
     * @return 更新行数
     */
    int updCartBySidService(Shoppingcart shoppingcart);

    /**
     * 设置购物车中的购物项为用户所有
     *
     * @param uid 用户id
     * @param sessionId sessionId
     * @return 更新行数
     */
    int updCartUidService(long uid, String sessionId);

    /**
     * 设置购物车中的购物项为用户所有(通过goodsId)
     *
     * @param uid       用户id
     * @param sessionId sessionId
     * @param goodsId   商品id
     * @return
     */
    int updCartUidByGidSidService(long uid, String sessionId, String goodsId);

    /**
     * 返回购物车中的所有信息
     *
     * @return
     */
    List<Shoppingcart> selAllService();

    /**
     * 根据用户id返回购物车
     *
     * @param uid 用户id
     * @return 购物车列表
     */
    List<Shoppingcart> selCartByUidService(long uid);

    /**
     * 根据商品id查找对象
     *
     * @param goodsId 商品id
     * @param uid 用户id
     * @return
     */
    Shoppingcart selCartByIdService(String goodsId, long uid);

    /**
     * 根据SessionId来查找对象
     *
     * @param sessionId sessionId
     * @return
     */
    List<Shoppingcart> selCartBySidService(String sessionId);

    /**
     * 根据SessionId来查找对象
     *
     * @param goodsId   商品id
     * @param sessionId sessionId
     * @return
     */
    Shoppingcart selCartBySidGidService(String goodsId, String sessionId);

    /**
     * 清空购物车
     * @param uid 用户id
     * @return 更新行数
     */
    int delAllService(long uid);

    /**
     * 清空购物车 （用户已登录）
     *
     * @param sessionId sessionId
     * @return 更新行数
     */
    int delAllBySidService(String sessionId);

    /**
     * 根据商品id从购物车中删除商品
     *
     * @param goodsId 需要删除的商品id
     * @param uid 用户id
     * @return 更新行数
     */
    int delItemService(String goodsId, long uid);

    /**
     * 根据商品id从购物车中删除商品 （用户未登录）
     *
     * @param goodsId   需要删除的商品id
     * @param sessionId sessionId
     * @return 更新行数
     */
    int delItemBySidService(String goodsId, String sessionId);
}
