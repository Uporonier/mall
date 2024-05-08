package com.example.mall.mapper;

import com.example.mall.entity.Cate2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface Cate2Mapper  {
    List<Cate2> getCate2ListByCate1Id(@Param("cate1Id") int cate1Id);
}
