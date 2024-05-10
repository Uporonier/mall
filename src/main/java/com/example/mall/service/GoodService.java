package com.example.mall.service;

import com.example.mall.entity.Good;
import com.example.mall.mapper.GoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodService {
    @Autowired
    private GoodMapper goodMapper;

    public Good findById(Long id) {
        return goodMapper.findById(id);
    }

    public void insert(Good good) {
        goodMapper.insert(good);
    }

    public void update(Good good) {
        goodMapper.update(good);
    }

    public void delete(Long id) {
        goodMapper.delete(id);
    }

    public List<Good> findByCategoryId(Integer categoryId) {
        return goodMapper.findByCateId1OrCateId2(categoryId);
    }
    public List<Map<String, Object>> findByCategoryIdWithMinPrice(Integer categoryId) {
        return goodMapper.findByCategoryIdWithMinPrice(categoryId);
    }

    public List<Map<String, Object>> findByCateIds(Integer cateid1, Integer cateid2) {
        return goodMapper.findByCateIds(cateid1, cateid2);
    }

    public List<Map<String, Object>> findByCateIdsWithMinPriceAndOrderBy(Integer cateid1, Integer cateid2, String orderBy) {
        switch (orderBy) {
            case "total_sales":
                return goodMapper.findByCateIdsWithMinPriceAndOrderByTotalSales(cateid1, cateid2);
            case "price":
                return goodMapper.findByCateIdsWithMinPriceAndOrderByPrice(cateid1, cateid2);
            case "createtime":
                return goodMapper.findByCateIdsWithMinPriceAndOrderByCreatetime(cateid1, cateid2);
            default:
                // 默认按照创建时间降序排序
                return goodMapper.findByCateIdsWithMinPriceAndOrderByCreatetime(cateid1, cateid2);
        }
    }

    public List<Map<String, Object>> filterByPriceRange(Integer cate1id, Integer cate2id, Double minPrice, Double maxPrice) {
        return goodMapper.findByCate1idAndCate2idAndPriceBetween(cate1id, cate2id, minPrice, maxPrice);
    }
}
