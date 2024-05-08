package com.example.mall.controller;

import com.example.mall.entity.Cate1;
import com.example.mall.service.Cate1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Cate1Controller {

    @Autowired
    private Cate1Service categoryService;

    @GetMapping("/categories")
    public List<Cate1> getCategories() {
        System.out.println(categoryService.getAllCategories());
        return categoryService.getAllCategories();
    }
}
