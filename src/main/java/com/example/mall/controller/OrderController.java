package com.example.mall.controller;

import com.example.mall.common.Result;
import com.example.mall.entity.Address;
import com.example.mall.entity.Order;
import com.example.mall.service.AddressService;
import com.example.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private AddressService addressService;
    @PostMapping("/create")
    public Result createOrder(@RequestBody Order order) {
        // 生成订单号（可根据当前时间和一定规则生成）
        String orderNo = generateOrderNo();

        // 设置订单信息
        order.setOrderno(orderNo);
        // 获取当前时间
        Date date = new Date();
        order.setCreatetime(date);
        order.setStatus("未支付"); // 待支付状态
        //获取地址信息
        Address address=addressService.getAddressById(order.getAddressid());
        order.setLinkaddress(address.getLinkaddress());
        order.setLinkname(address.getLinkname());
        order.setLinkphone(address.getLinkphone());
        // 保存订单
        boolean suc=orderService.createOrder(order);
        if(suc){

            System.out.println("------------创建订单-----------");
            System.out.println(order);
            return Result.success("创建订单成功!");
        }
        else{
            return Result.error();
        }
    }

    // 可根据具体需求修改订单号生成规则
    private String generateOrderNo() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 20);
    }
}
