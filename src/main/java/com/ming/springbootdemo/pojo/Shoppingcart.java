package com.ming.springbootdemo.pojo;


public class Shoppingcart {

    private long id;
    private long goodsId;
    private long count;
    private long uid;
    private String sessionId;
    private Goods goods;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }


    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }


    public java.sql.Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.sql.Timestamp createTime) {
        this.createTime = createTime;
    }


    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "Shoppingcart{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", count=" + count +
                ", uid=" + uid +
                ", sessionId='" + sessionId + '\'' +
                ", goods=" + goods +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
