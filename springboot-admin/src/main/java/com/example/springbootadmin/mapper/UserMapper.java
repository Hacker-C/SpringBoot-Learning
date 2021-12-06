package com.example.springbootadmin.mapper;

import com.example.springbootadmin.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    // 添加数据
    @Insert("insert user(username,password,nickname,age,sex,address) value( #{username},#{password},#{nickname},#{age},#{sex},#{address});")
    void save(User user);

    // 分页查询 + 模糊查询
    @Select("select * from user where concat(id,' ', username,' ', nickname,' ', age,' ', sex,' ', address) like '%${key}%' limit #{offset},#{pageSize}")
    List<User> findByPage(@Param("offset") Integer offset, @Param("pageSize") Integer pageSize, @Param("key") String key);

    // 计算数据库中用户数
    @Select("select count(id) from user")
    Integer countUser();

    // 更新数据
    @Update("update user set username=#{username},nickname=#{nickname},age=#{age},sex=#{sex},address=#{address} where id=#{id}")
    void update(User user);

    // 删除数据
    @Delete("delete from user where id=#{id}")
    void delete(int id);

    // 登录查询
    @Select("select * from user where username=#{username} and password=#{password}")
    User login(@Param("username") String username, @Param("password") String password);

    // 根据用户名查询是否存在这个用户
    @Select("select * from user where username=#{username}")
    User find(String username);
}
