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

    /**
     * 根据cateid1和cateid2查询商品列表，并计算出最低价格
     * @param cateid1 大类ID
     * @param cateid2 小类ID
     * @param orderBy 排序方式，可选值为"total_sales"（累计销量）、"price"（价格）、"createtime"（新品）
     * @return 商品列表，包含最低价格
     */
//    @Select("SELECT g.*, (SELECT MIN(price) FROM standard s WHERE s.goodid = g.id) AS min_price " +
//            "FROM good g WHERE cateid1 = #{cateid1} AND cateid2 = #{cateid2} " +
//            "ORDER BY " +
//            "CASE #{orderBy} " +
//            "   WHEN 'total_sales' THEN salenum DESC " + // salenum 降序
//            "   WHEN 'price' THEN min_price ASC " +      // min_price 升序
//            "   WHEN 'createtime' THEN g.createtime DESC " + // createtime 降序
//            "END")
//    List<Map<String, Object>> findByCateIdsWithMinPriceAndOrderBy(@Param("cateid1") Integer cateid1, @Param("cateid2") Integer cateid2, @Param("orderBy") String orderBy);
    // 根据销量降序排序
    @Select("SELECT g.*, (SELECT MIN(price) FROM standard s WHERE s.goodid = g.id) AS min_price " +
            "FROM good g WHERE cateid1 = #{cateid1} AND cateid2 = #{cateid2} " +
            "ORDER BY salenum DESC")
    List<Map<String, Object>> findByCateIdsWithMinPriceAndOrderByTotalSales(@Param("cateid1") Integer cateid1, @Param("cateid2") Integer cateid2);

    // 根据价格升序排序
    @Select("SELECT g.*, (SELECT MIN(price) FROM standard s WHERE s.goodid = g.id) AS min_price " +
            "FROM good g WHERE cateid1 = #{cateid1} AND cateid2 = #{cateid2} " +
            "ORDER BY min_price ASC")
    List<Map<String, Object>> findByCateIdsWithMinPriceAndOrderByPrice(@Param("cateid1") Integer cateid1, @Param("cateid2") Integer cateid2);

    // 根据创建时间降序排序
    @Select("SELECT g.*, (SELECT MIN(price) FROM standard s WHERE s.goodid = g.id) AS min_price " +
            "FROM good g WHERE cateid1 = #{cateid1} AND cateid2 = #{cateid2} " +
            "ORDER BY createtime DESC")
    List<Map<String, Object>> findByCateIdsWithMinPriceAndOrderByCreatetime(@Param("cateid1") Integer cateid1, @Param("cateid2") Integer cateid2);

    @Select("SELECT g.*, (SELECT MIN(price) FROM standard s WHERE s.goodid = g.id) AS min_price " +
            "FROM good g WHERE cateid1 = #{cate1id} AND cateid2 = #{cate2id} " +
            "GROUP BY g.id " +
            "HAVING min_price BETWEEN #{minPrice} AND #{maxPrice}")
    List<Map<String, Object>> findByCate1idAndCate2idAndPriceBetween(@Param("cate1id") int cate1id, @Param("cate2id") int cate2id,
                                                                     @Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice);

}
