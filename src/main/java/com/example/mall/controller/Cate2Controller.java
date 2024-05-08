package com.example.mall.controller;

import com.example.mall.entity.Cate2;
import com.example.mall.mapper.Cate2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("cate2")
public class Cate2Controller {
    @Autowired
    private Cate2Mapper cate2Mapper;

    @GetMapping("list/{cate1Id}")
    public List<Cate2> getCate2ListByCate1Id(@PathVariable int cate1Id) {
        System.out.println("-------小类---------");
        System.out.println(cate2Mapper.getCate2ListByCate1Id(cate1Id));
        return cate2Mapper.getCate2ListByCate1Id(cate1Id);
    }
}
