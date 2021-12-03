package top.mphy.springbootlogin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import top.mphy.springbootlogin.entity.User;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM `user` WHERE username= #{username} AND `password` = #{password};")
    User getUsernameAndPassword(User user);
}
