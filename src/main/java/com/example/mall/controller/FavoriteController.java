package com.example.mall.controller;

import com.example.mall.entity.Favorite;
import com.example.mall.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    // 添加收藏
    @PostMapping("/add")
    public int addFavorite(@RequestBody Favorite favorite) {
        favorite.setLovetime(new Date()); // 设置为当前时间
        return favoriteService.addFavorite(favorite);
    }

    // 删除收藏
    @DeleteMapping("/remove/{goodid}/{userid}")
    public int removeFavorite(@PathVariable int goodid, @PathVariable int userid) {
        return favoriteService.removeFavorite(goodid, userid);
    }

    //查询是否已经存在过当前用户当前商品的收藏信息
    @GetMapping("/checkExist/{goodid}/{userid}")
    public boolean checkExist(@PathVariable int goodid, @PathVariable int userid) {
        return favoriteService.checkExist(goodid, userid);
    }
}
