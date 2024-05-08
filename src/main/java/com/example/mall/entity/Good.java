package com.example.mall.entity;

import java.util.Date;

public class Good {
    private Long id;
    private Integer cateid1;
    private Integer cateid2;
    private String name;
    private String description;
    private String imgs;
    private Date createtime;
    private int salenum;
    private int salemoney;
    private int shopid;
    private String detail;

    public int getShopid() {
        return shopid;
    }

    public void setShopid(int shopid) {
        this.shopid = shopid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

// Getters and setters

    public int getSalenum() {
        return salenum;
    }

    public void setSalenum(int salenum) {
        this.salenum = salenum;
    }

    public int getSalemoney() {
        return salemoney;
    }

    public void setSalemoney(int salemoney) {
        this.salemoney = salemoney;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCateid1() {
        return cateid1;
    }

    public void setCateid1(Integer cateid1) {
        this.cateid1 = cateid1;
    }

    public Integer getCateid2() {
        return cateid2;
    }

    public void setCateid2(Integer cateid2) {
        this.cateid2 = cateid2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", cateid1=" + cateid1 +
                ", cateid2=" + cateid2 +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgs='" + imgs + '\'' +
                ", createtime=" + createtime +
                ", salenum=" + salenum +
                ", salemoney=" + salemoney +
                '}';
    }
}
