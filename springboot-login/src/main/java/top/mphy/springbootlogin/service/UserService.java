package top.mphy.springbootlogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mphy.springbootlogin.entity.User;
import top.mphy.springbootlogin.mapper.UserMapper;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUsernameAndPassword(User user) {
        return userMapper.getUsernameAndPassword(user);
    }
}
