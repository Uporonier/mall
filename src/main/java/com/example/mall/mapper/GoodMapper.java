package com.example.mall.mapper;

import com.example.mall.entity.Good;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodMapper {
    @Select("SELECT * FROM good WHERE id = #{id}")
    Good findById(Long id);

    @Insert("INSERT INTO good(cateid1, cateid2, name, description, imgs, createtime) " +
            "VALUES(#{cateid1}, #{cateid2}, #{name}, #{description}, #{imgs}, #{createtime})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Good good);

    @Update("UPDATE good SET cateid1 = #{cateid1}, cateid2 = #{cateid2}, name = #{name}, " +
            "description = #{description}, imgs = #{imgs}, createtime = #{createtime} WHERE id = #{id}")
    void update(Good good);

    @Delete("DELETE FROM good WHERE id = #{id}")
    void delete(Long id);

    @Select("SELECT * FROM good WHERE cateid1 = #{categoryId}")
    List<Good> findByCateId1OrCateId2(Integer categoryId1);

    @Select("SELECT g.*, (SELECT MIN(price) FROM standard s WHERE s.goodid = g.id) AS min_price " +
            "FROM good g " +
            "WHERE g.cateid1 = #{categoryId} ")
    List<Map<String, Object>> findByCategoryIdWithMinPrice(@Param("categoryId") Integer categoryId);

    /**  根据cate1id cate2id 查询*/
    @Select("SELECT g.* ,(SELECT MIN(price) FROM standard s WHERE s.goodid = g.id) AS min_price " +
            "FROM good g WHERE cateid1 = #{cateid1} AND cateid2 = #{cateid2}")
    List<Map<String, Object>> findByCateIds(@Param("cateid1") Integer cateid1, @Param("cateid2") Integer cateid2);


}
