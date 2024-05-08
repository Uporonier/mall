package com.example.mall.service;

import com.example.mall.mapper.StandardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandardService {

    @Autowired
    private StandardMapper standardMapper;

    public float findMinPriceByGoodid(int goodid) {
        return standardMapper.findMinPriceByGoodid(goodid);
    }

}
