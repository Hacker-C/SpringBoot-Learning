package com.example.springbootadmin.service;

import com.example.springbootadmin.entity.User;
import com.example.springbootadmin.mapper.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public String addUser(User user) {
        userMapper.save(user);
        return "ok";
    }

    public List<User> findByPage(@Param("offset") int offset, @Param("pageSize") int pageSize, @Param("key") String key) {
        return userMapper.findByPage(offset, pageSize, key);
    }

    public int countUser() {
        return userMapper.countUser();
    }

}
