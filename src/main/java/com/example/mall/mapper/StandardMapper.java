package com.example.mall.mapper;

import com.example.mall.entity.Standard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StandardMapper {

    float findMinPriceByGoodid(int goodid);

    List<Standard> findByGoodId(@Param("goodId") int goodId);

}
