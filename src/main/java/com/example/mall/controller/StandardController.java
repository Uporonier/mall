package com.example.mall.controller;

import com.example.mall.common.Result;
import com.example.mall.entity.Standard;
import com.example.mall.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/standard")
public class StandardController {

    @Autowired
    private StandardService standardService;

    @GetMapping("/minprice/{goodid}")
    public Result findMinPriceByGoodid(@PathVariable int goodid) {
        boolean flag=true;
        float minPrice =0;
        try{
             minPrice = standardService.findMinPriceByGoodid(goodid);
             flag=true;
        }
        catch (Exception e){
            return Result.success("--");
        }
        if(flag)
            return Result.success(String.valueOf(minPrice));
        else
            return  Result.success("--");

    }

    //获得商品对应的尺寸
    @GetMapping("/{goodId}")
    public Result getStandardsByGoodId(@PathVariable int goodId) {
        List<Standard> standards = standardService.getStandardsByGoodId(goodId);
        return Result.success(standards);
    }
}
