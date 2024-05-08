package com.example.mall.controller;

import com.example.mall.common.Result;
import com.example.mall.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/standard")
public class StandardController {

    @Autowired
    private StandardService standardService;

    @GetMapping("/minprice/{goodid}")
    public Result findMinPriceByGoodid(@PathVariable int goodid) {
        float minPrice = standardService.findMinPriceByGoodid(goodid);
        if(minPrice==0)
        return Result.success(String.valueOf(minPrice));
        else
            return Result.success("--");
    }

}
