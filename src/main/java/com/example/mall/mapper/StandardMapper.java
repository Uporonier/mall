package com.example.mall.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StandardMapper {

    float findMinPriceByGoodid(int goodid);

}
