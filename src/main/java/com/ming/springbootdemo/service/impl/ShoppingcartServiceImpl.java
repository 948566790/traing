package com.ming.springbootdemo.service.impl;

import com.ming.springbootdemo.dao.ShoppingcartMapper;
import com.ming.springbootdemo.pojo.Shoppingcart;
import com.ming.springbootdemo.service.ShoppingcartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShoppingcartServiceImpl implements ShoppingcartService {
    @Resource
    private ShoppingcartMapper shoppingcartMapper;

    @Override
    public int addGoodsToCartService(String goodsId, long uid) {
        return shoppingcartMapper.addGoodsToCart(goodsId, uid);
    }

    @Override
    public int addGoodsToCartBySidService(String goodsId, String sessionId) {
        return shoppingcartMapper.addGoodsToCartBySid(goodsId, sessionId);
    }

    @Override
    public int updCartService(Shoppingcart shoppingcart) {
        return shoppingcartMapper.updCart(shoppingcart);
    }

    @Override
    public int updCartBySidService(Shoppingcart shoppingcart) {
        return shoppingcartMapper.updCartBySid(shoppingcart);
    }

    @Override
    public int updCartUidService(long uid, String session) {
        return shoppingcartMapper.updCartUid(uid, session);
    }

    @Override
    public int updCartUidByGidSidService(long uid, String sessionId, String goodsId) {
        return shoppingcartMapper.updCartUidByGidSid(uid, sessionId, goodsId);
    }

    @Override
    public List<Shoppingcart> selAllService() {
        return shoppingcartMapper.selAll();
    }

    @Override
    public List<Shoppingcart> selCartByUidService(long uid) {
        return shoppingcartMapper.selCartByUid(uid);
    }

    @Override
    public Shoppingcart selCartByIdService(String goodsId, long uid) {
        return shoppingcartMapper.selCartById(goodsId, uid);
    }

    @Override
    public List<Shoppingcart> selCartBySidService(String sessionId) {
        return shoppingcartMapper.selCartBySid(sessionId);
    }

    @Override
    public Shoppingcart selCartBySidGidService(String goodsId, String sessionId) {
        return shoppingcartMapper.selCartBySidGid(goodsId, sessionId);
    }

    @Override
    public int delAllService(long uid) {
        return shoppingcartMapper.delAll(uid);
    }

    @Override
    public int delAllBySidService(String sessionId) {
        return shoppingcartMapper.delAllBySid(sessionId);
    }

    @Override
    public int delItemService(String goodsId, long uid) {
        return shoppingcartMapper.delItem(goodsId, uid);
    }

    @Override
    public int delItemBySidService(String goodsId, String sessionId) {
        return shoppingcartMapper.delItemBySid(goodsId, sessionId);
    }
}
