package com.ming.springbootdemo.service.impl;

import com.ming.springbootdemo.dao.GoodsMapper;
import com.ming.springbootdemo.pojo.Goods;
import com.ming.springbootdemo.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public Goods selByIdService(String id) {
        return goodsMapper.selById(id);
    }

    @Override
    public Goods selByNameService(String name) {
        return goodsMapper.selByName(name);
    }

    @Override
    public List<Goods> selAllGooodsService() {
        return goodsMapper.selAllGoods();
    }

    @Override
    public int reduceStockService(String goodsId, long reduce) {
        return goodsMapper.reduceStock(goodsId, reduce);
    }

    @Override
    public List<Goods> searchService(String word) {
        return goodsMapper.search(word);
    }
}
