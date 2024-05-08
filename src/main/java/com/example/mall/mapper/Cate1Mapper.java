package com.example.mall.mapper;

import com.example.mall.entity.Cate1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Cate1Mapper {
    @Select("SELECT id, name FROM cate1")
    List<Cate1> getAllCategories();
}
