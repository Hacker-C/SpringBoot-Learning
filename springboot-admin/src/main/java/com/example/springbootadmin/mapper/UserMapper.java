package com.example.springbootadmin.mapper;

import com.example.springbootadmin.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    // 添加数据
    @Insert("insert user(username,password,nickname,age,sex,address) value( #{username},#{password},#{nickname},#{age},#{sex},#{address});")
    void save(User user);

    // 分页查询 + 模糊查询
    @Select("select * from user where concat(id,' ', username,' ', nickname,' ', age,' ', sex,' ', address) like '%${key}%' limit #{offset},#{pageSize}")
    List<User> findByPage(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize, @Param("key") String key);

    //
    @Select("select count(id) from user")
    Integer countUser();

}
