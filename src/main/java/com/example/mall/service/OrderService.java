package com.example.mall.service;

import com.example.mall.entity.Order;
import com.example.mall.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    public boolean createOrder(Order order) {
      return orderMapper.createOrder(order)>0;
    }
}
