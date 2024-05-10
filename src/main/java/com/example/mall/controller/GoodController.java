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
//        System.out.println("----------------");
//        System.out.println(categoryId);
//        System.out.println(goods);
        return Result.success(goods);
    }

    /** 根据大类 小类查询商品 */
    @PostMapping(value = "/getcategory/{cate1id}/{cate2id}")
    public Result findByCateIds(@PathVariable Integer cate1id, @PathVariable Integer cate2id) {
        List<Map<String, Object>> goods = goodService.findByCateIds(cate1id, cate2id);
        System.out.println(goods);
        return Result.success(goods);
    }


    @GetMapping("/{cateid1}/{cateid2}")
    public Result findByCateIdsWithOrderBy(@PathVariable Integer cateid1, @PathVariable Integer cateid2, @RequestParam(required = false, defaultValue = "createtime") String orderBy) {
        List<Map<String, Object>> goods = goodService.findByCateIdsWithMinPriceAndOrderBy(cateid1, cateid2, orderBy);
        return Result.success(goods);
    }
    @PostMapping("/filter/{cate1id}/{cate2id}/{minPrice}/{maxPrice}")
    public Result filterGoods(@PathVariable Integer cate1id, @PathVariable Integer cate2id,
                              @PathVariable Double minPrice, @PathVariable Double maxPrice) {
        List<Map<String, Object>> filteredGoods = goodService.filterByPriceRange(cate1id, cate2id, minPrice, maxPrice);
        return Result.success(filteredGoods);
    }



}

