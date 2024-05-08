package com.example.mall.controller;

import com.example.mall.common.Constants;
import com.example.mall.common.Result;
import com.example.mall.entity.Good;
import com.example.mall.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodController {
    @Autowired
    private GoodService goodService;

    @GetMapping("/{id}")
    public Result findById(@PathVariable Long id) {
        Good good = goodService.findById(id);
        if (good == null) {
//            return ResponseEntity.notFound().build();
            return Result.error("商品不存在");
        }
        System.out.println(good);
        return Result.success(good);
    }

    @PostMapping
    public void insert(@RequestBody Good good) {
        goodService.insert(good);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Good good) {
        good.setId(id);
        goodService.update(good);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        goodService.delete(id);

    }
//    @PostMapping(value = "/category" )
//    public Result findByCategoryId(@RequestParam Integer categoryId) {
//        List<Good> goods = goodService.findByCategoryId(categoryId);
//        return Result.success(goods);
//    }
    @PostMapping(value = "/category" )
    public Result findByCategoryIdWithMinPrice(@RequestParam Integer categoryId) {
        List<Map<String, Object>> goods = goodService.findByCategoryIdWithMinPrice(categoryId);
        System.out.println("----------------");
        System.out.println(categoryId);
        System.out.println(goods);
        return Result.success(goods);
    }

    /**  查询某个id商品的 最低价格  */

}

