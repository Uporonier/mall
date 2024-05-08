package com.example.mall.entity;

public class Cate2 {
    private int id;
    private String name;
    private int cateid1;//小类所属大类
    private String cate2img;//小类图标

    public int getCateid1() {
        return cateid1;
    }

    public void setCateid1(int cateid1) {
        this.cateid1 = cateid1;
    }

    public String getCate2img() {
        return cate2img;
    }

    public void setCate2img(String cate2img) {
        this.cate2img = cate2img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cate2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cateid1=" + cateid1 +
                ", cate2img='" + cate2img + '\'' +
                '}';
    }
}
