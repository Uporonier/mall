package com.example.mall.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Order {
    private int id;
    private int goodid;
    private String orderno;
    private int userid;
    private int standardid;
    private int addressid;
    private Date createtime;
    private String status;
    private String linkname;
    private String linkphone;
    private String linkaddress;


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

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getStandardid() {
        return standardid;
    }

    public void setStandardid(int standardid) {
        this.standardid = standardid;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLinkname() {
        return linkname;
    }

    public void setLinkname(String linkname) {
        this.linkname = linkname;
    }

    public String getLinkphone() {
        return linkphone;
    }

    public void setLinkphone(String linkphone) {
        this.linkphone = linkphone;
    }

    public String getLinkaddress() {
        return linkaddress;
    }

    public void setLinkaddress(String linkaddress) {
        this.linkaddress = linkaddress;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", goodid=" + goodid +
                ", orderno='" + orderno + '\'' +
                ", userid=" + userid +
                ", standardid=" + standardid +
                ", addressid=" + addressid +
                ", createtime=" + createtime +
                ", status='" + status + '\'' +
                ", linkname='" + linkname + '\'' +
                ", linkphone='" + linkphone + '\'' +
                ", linkaddress='" + linkaddress + '\'' +
                '}';
    }
}
