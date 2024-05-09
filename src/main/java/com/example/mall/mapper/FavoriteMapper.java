package com.example.mall.mapper;

import com.example.mall.entity.Favorite;
import org.apache.ibatis.annotations.*;

@Mapper
public interface FavoriteMapper {

    // 增加收藏信息
    @Insert("INSERT INTO favorite (goodid, userid, lovetime) VALUES (#{favorite.goodid}, #{favorite.userid}, #{favorite.lovetime})")
    int addFavorite(@Param("favorite") Favorite favorite);

    // 删除收藏信息
    @Delete("DELETE FROM favorite WHERE goodid = #{goodid} AND userid = #{userid}")
    int removeFavorite(@Param("goodid") int goodid, @Param("userid") int userid);

    // 查询是否已存在收藏信息
    @Select("SELECT COUNT(*) FROM favorite WHERE goodid = #{goodid} AND userid = #{userid}")
    int checkExist(@Param("goodid") int goodid, @Param("userid") int userid);
}
