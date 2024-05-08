package com.example.mall.service;

import com.example.mall.entity.Good;
import com.example.mall.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodService {
    @Autowired
    private GoodMapper goodMapper;

    public Good findById(Long id) {
        return goodMapper.findById(id);
    }

    public void insert(Good good) {
        goodMapper.insert(good);
    }

    public void update(Good good) {
        goodMapper.update(good);
    }

    public void delete(Long id) {
        goodMapper.delete(id);
    }

    public List<Good> findByCategoryId(Integer categoryId) {
        return goodMapper.findByCateId1OrCateId2(categoryId);
    }
    public List<Map<String, Object>> findByCategoryIdWithMinPrice(Integer categoryId) {
        return goodMapper.findByCategoryIdWithMinPrice(categoryId);
    }
}
