package com.springboot.multidatasource.test01.mapper;

import com.springboot.multidatasource.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapperTest01 {

    // 查询语句
    @Select("SELECT * FROM USERS WHERE NAME = #{name}")
    User findByName(@Param("name") String name);

    // 添加
    @Insert("INSERT INTO USERS(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String name, @Param("age") Integer age);

    // 查询用户
    @Select("SELECT * FROM USERS")
    List<User> getUsers();

}
