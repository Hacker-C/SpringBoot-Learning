package top.mphy.blog.springbootapi.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.transaction.annotation.Transactional;
import top.mphy.blog.springbootapi.entity.User;

import java.util.List;

// *mapper持久层(==dao层)，主要与数据库进行交互，编写SQL代码。
// *DAO层会调用entity层，DAO中会定义实际使用到的方法，比如增删改查。
// *DAO 层的数据源和数据库连接的参数都是在配置文件中进行配置的，配置文件在application.yml中
// *数据持久化操作就是指，把数据放到持久化的介质中，同时提供增删改查操作。
@Mapper
public interface UserMapper {
    // 注解+sql实现查询
    // 查询所有与用户信息
    @Select("select * from user")
    List<User> findAll();

    // 根据id查询用户的所有信息
    @Select("select * from user where id=#{id}")
    @Transactional
    List<User> getUserById(int id);

    // post请求，添加一条数据
    @Update("INSERT INTO `user` (`name`, `address`, `age`, `sex`, `phone`) " +
            "VALUES (#{name}, #{address}, #{age}, #{sex}, #{phone});")
    // 事务注解
    @Transactional
    void save(User user);

    // 修改用户数据
    @Update({"<script>",
            "update user",
            "   <set>",
            "       <if test='name != null'>name=#{name},</if>",
            "       <if test='address != null'>address=#{address},</if>",
            "       <if test='age != 0'>age=#{age},</if>",
            "       <if test='sex != null'>sex=#{sex},</if>",
            "       <if test='phone != null'>phone=#{phone},</if>",
            "   </set>",
            "where id=#{id}",
            "</script>"})
    @Transactional
    void updateById(User user);

    // 删除用户数据
    @Delete("delete from user where id=#{id}")
    @Transactional
    void delete(int id);
}
