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

    public int addUser(User user) {
        userMapper.save(user);
        return 0;
    }

    public List<User> findByPage(@Param("offset") int offset, @Param("pageSize") int pageSize, @Param("key") String key) {
        return userMapper.findByPage(offset, pageSize, key);
    }

    public int countUser() {
        return userMapper.countUser();
    }

    public int updateUserById(User user) {
        userMapper.update(user);
        return 0;
    }

    public int deleteUserById(int id) {
        userMapper.delete(id);
        return 0;
    }

    public User login(@Param("username") String username, @Param("password") String password) {
        return userMapper.login(username, password);
    }

    public User find(String name) {
        return  userMapper.find(name);
    }

}
