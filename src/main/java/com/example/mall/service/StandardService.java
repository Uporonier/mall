package com.example.mall.service;

import com.example.mall.entity.Standard;
import com.example.mall.mapper.StandardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardService {

    @Autowired
    private StandardMapper standardMapper;

    public float findMinPriceByGoodid(int goodid) {
        return standardMapper.findMinPriceByGoodid(goodid);
    }


    public List<Standard> getStandardsByGoodId(int goodId) {
        return standardMapper.findByGoodId(goodId);
    }
}
