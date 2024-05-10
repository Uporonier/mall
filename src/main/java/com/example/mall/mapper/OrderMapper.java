package com.example.mall.mapper;

import com.example.mall.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO `order` (orderno, userid, goodid, standardid, createtime, status, linkname, linkaddress, linkphone, addressid) " +
            "VALUES (#{orderno}, #{userid}, #{goodid}, #{standardid}, #{createtime}, #{status}, #{linkname}, #{linkaddress}, #{linkphone}, #{addressid})")
    int createOrder(Order order);
}
