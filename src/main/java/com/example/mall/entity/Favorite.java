package com.example.mall.entity;


import java.util.Date;

public class Favorite {
    private int id;
    private int goodid;
    private int userid;
    private Date lovetime;


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

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getLovetime() {
        return lovetime;
    }

    public void setLovetime(Date lovetime) {
        this.lovetime = lovetime;
    }
}
