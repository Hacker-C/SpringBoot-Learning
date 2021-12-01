package top.mphy.blog.springbootapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.mphy.blog.springbootapi.entity.User;
import top.mphy.blog.springbootapi.mapper.UserMapper;

import java.util.List;

// !业务层 控制业务
// *Service层主要负责业务模块的逻辑应用设计。先设计放接口的类，再创建实现的类。
// *service层调用mapper层接口，接收mapper层返回的数据，完成项目的基本功能设计。

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {
        return userMapper.findAll();
    }

    public List<User> getUserInfoById(int id) {
        return userMapper.getUserById(id);
    }

    public String addUser(User user) {
        userMapper.save(user);
        return "add success";
    }

    public String updateById(User user) {
        userMapper.updateById(user);
        return "update success";
    }

    public String deleteById(int id) {
        userMapper.delete(id);
        return "delete success";
    }

}
