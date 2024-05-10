package com.example.mall.mapper;

import com.example.mall.entity.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressMapper {

    @Select("SELECT * FROM address WHERE userid = #{userId}")
    List<Address> findByUserId(int userId);

    @Select("SELECT * FROM address WHERE id = #{id}")
    Address findById(int id);

    @Insert("INSERT INTO address(userid, linkname, linkaddress, linkphone) " +
            "VALUES(#{userid}, #{linkname}, #{linkaddress}, #{linkphone})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(Address address);

    @Update("UPDATE address SET userid = #{userid}, linkname = #{linkname}, " +
            "linkaddress = #{linkaddress}, linkphone = #{linkphone} WHERE id = #{id}")
    void update(Address address);

    @Delete("DELETE FROM address WHERE id = #{id}")
    void delete(int id);
}
