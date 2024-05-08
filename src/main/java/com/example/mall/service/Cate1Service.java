package com.example.mall.service;

import com.example.mall.entity.Cate1;
import com.example.mall.mapper.Cate1Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Cate1Service {

    @Autowired
    private Cate1Mapper categoryMapper;


    public List<Cate1> getAllCategories() {
        return categoryMapper.getAllCategories();
    }
}