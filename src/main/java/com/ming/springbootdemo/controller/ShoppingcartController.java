package com.ming.springbootdemo.controller;

import com.ming.springbootdemo.pojo.Goods;
import com.ming.springbootdemo.pojo.Orderdetail;
import com.ming.springbootdemo.pojo.Shoppingcart;
import com.ming.springbootdemo.pojo.User;
import com.ming.springbootdemo.service.GoodsService;
import com.ming.springbootdemo.service.OrderDetailService;
import com.ming.springbootdemo.service.OrderService;
import com.ming.springbootdemo.service.ShoppingcartService;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ShoppingcartController {
    @Resource
    private ShoppingcartService shoppingcartServiceImpl;
    @Resource
    private GoodsService goodsServiceImpl;
    @Resource
    private OrderService orderServiceImpl;
    @Resource
    private OrderDetailService orderDetailServiceImpl;

    @RequestMapping("/addGoodsToCart")
    public String addGoodsToCart(String goodsId, HttpServletRequest request, HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("user");
        if (goodsId != null && !goodsId.equals("")) {
            if (user == null) {
                //1.用户未登录,保存sessionId
                String sessionId = request.getSession().getId();
                Shoppingcart shoppingcart = shoppingcartServiceImpl.selCartBySidGidService(goodsId, sessionId);
                if (shoppingcart == null) {
                    //添加购物车（如购物车未存在该商品，才加入购物车）
                    shoppingcartServiceImpl.addGoodsToCartBySidService(goodsId, sessionId);
                }
            } else { //2.用户已登录
                Shoppingcart shoppingcart = shoppingcartServiceImpl.selCartByIdService(goodsId, user.getUid());
                if (shoppingcart == null) {
                    //添加购物车（如购物车未存在该商品，才加入购物车）
                    shoppingcartServiceImpl.addGoodsToCartService(goodsId, user.getUid());
                }
            }
        }
        return "goods";
    }

    @RequestMapping("/shoppingcart")
    public String selAll(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        List<Shoppingcart> carts = null;
        if (user == null) {
            //用户未登录，显示未分配的购物项
            carts = shoppingcartServiceImpl.selCartBySidService(request.getSession().getId());
        } else {//用户已登录：
            // 1.用户留有保存的购物项，显示这些购物项并将sessionid相同的购物项加入该用户的购物车中。
            // 2.用户没有购物项，显示未分配的购物项，并分配给该用户
            carts = shoppingcartServiceImpl.selCartByUidService(user.getUid());
            if (carts == null || carts.isEmpty()) {
                shoppingcartServiceImpl.updCartUidService(user.getUid(), request.getSession().getId());
            } else {
                List<Shoppingcart> shoppingcarts = shoppingcartServiceImpl.selCartBySidService(request.getSession().getId());
                for (Shoppingcart shoppingcart : shoppingcarts) {
                    Shoppingcart shoppingcart1 = shoppingcartServiceImpl.selCartByIdService(shoppingcart.getGoodsId() + "", user.getUid());
                    if (shoppingcart1 == null) {
                        shoppingcartServiceImpl.updCartUidByGidSidService(user.getUid(), request.getSession().getId(), shoppingcart.getGoodsId() + "");
                    }else {
                        shoppingcartServiceImpl.delItemBySidService(shoppingcart.getGoodsId()+"",shoppingcart.getSessionId());
                    }
                }
            }
            carts = shoppingcartServiceImpl.selCartByUidService(user.getUid());
        }
        request.setAttribute("carts", carts);
        return "shoppingcart";
    }

    @RequestMapping("/delAll")
    public String delAll(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            //1.用户未登录
            shoppingcartServiceImpl.delAllBySidService(request.getSession().getId());
        } else {//2.用户已登录
            shoppingcartServiceImpl.delAllService(user.getUid());
        }

        return "forward:/shoppingcart";
    }

    @RequestMapping("/delOne")
    public String delOne(String goodsId, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            //1.用户未登录
            shoppingcartServiceImpl.delItemBySidService(goodsId, request.getSession().getId());
        } else {//2.用户已登录
            shoppingcartServiceImpl.delItemService(goodsId, user.getUid());
        }
        return "forward:/shoppingcart";
    }

    @RequestMapping("/upd")
    @ResponseBody
    public Goods updGoodsStock(String goodsId, String count, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Goods goods = goodsServiceImpl.selByIdService(goodsId);
        if (goodsId != null && count != null) {
            if (user == null) {
                //1.用户未登录
                if (goods.getStock() >= Integer.parseInt(count)) {
                    Shoppingcart shoppingcart = new Shoppingcart();
                    shoppingcart.setCount(Integer.parseInt(count));
                    shoppingcart.setGoodsId(Integer.parseInt(goodsId));
                    shoppingcart.setSessionId(request.getSession().getId());
                    shoppingcartServiceImpl.updCartBySidService(shoppingcart);
                }
            } else {
                //2.用户已登录
                if (goods.getStock() >= Integer.parseInt(count)) {
                    Shoppingcart shoppingcart = new Shoppingcart();
                    shoppingcart.setCount(Integer.parseInt(count));
                    shoppingcart.setGoodsId(Integer.parseInt(goodsId));
                    shoppingcart.setUid(user.getUid());
                    shoppingcartServiceImpl.updCartService(shoppingcart);
                }
            }

        }
        return goods;
    }

    @RequestMapping(value = "/push", produces = "text/html;charset=utf8")
    @ResponseBody
    public String push(@RequestParam(value = "goodsIdList[]", required = false) String[] goodsIdList, String chosePrice, HttpServletRequest request) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        if (goodsIdList!=null) {
            String uuid = UUID.randomUUID().toString();
            orderServiceImpl.addOrderService(Integer.parseInt(chosePrice),user.getUid(),uuid);
            for (String goodsId : goodsIdList) {
                //将所选购物车内容取出放在订单详情中，并减少库存量
                Shoppingcart shoppingcart = shoppingcartServiceImpl.selCartByIdService(goodsId, user.getUid());
                Orderdetail orderdetail = new Orderdetail();
                orderdetail.setGoodsId(shoppingcart.getGoodsId());
                orderdetail.setCount(shoppingcart.getCount());
                orderdetail.setOrderNum(uuid);
                orderDetailServiceImpl.addOrderDetailService(orderdetail);
                goodsServiceImpl.reduceStockService(goodsId, shoppingcart.getCount());
                shoppingcartServiceImpl.delItemService(goodsId, user.getUid());
            }
        }
        return "提交成功";
    }
}
