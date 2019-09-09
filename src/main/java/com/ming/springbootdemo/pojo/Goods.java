package com.ming.springbootdemo.pojo;


public class Goods {

    private long goodsId;
    private String goodsName;
    private long stock;
    private long price;
    private long Bid;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;


    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }


    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }


    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }


    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
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

    public long getBid() {
        return Bid;
    }

    public void setBid(long bid) {
        Bid = bid;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", Bid=" + Bid +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
