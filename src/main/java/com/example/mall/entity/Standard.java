package com.example.mall.entity;

public class Standard {
    private int id;
    private int goodid;
    private float price;
    private int store;
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodid() {
        return goodid;
    }

    public void setGoodid(int goodid) {
        this.goodid = goodid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Standard{" +
                "id=" + id +
                ", goodid=" + goodid +
                ", price=" + price +
                ", store=" + store +
                ", value='" + value + '\'' +
                '}';
    }
}
