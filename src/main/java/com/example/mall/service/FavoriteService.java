package com.example.mall.service;

import com.example.mall.entity.Favorite;
import com.example.mall.mapper.FavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {
    @Autowired
    private FavoriteMapper favoriteMapper;

    // 添加收藏
    public int addFavorite(Favorite favorite) {
        return favoriteMapper.addFavorite(favorite);
    }

    // 删除收藏
    public int removeFavorite(int goodid, int userid) {
        return favoriteMapper.removeFavorite(goodid, userid);
    }

    // 检查是否已存在收藏信息
    public boolean checkExist(int goodid, int userid) {
        return favoriteMapper.checkExist(goodid, userid) > 0;
    }
}
