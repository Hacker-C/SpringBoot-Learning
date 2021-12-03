package top.mphy.springbootlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.mphy.springbootlogin.entity.User;
import top.mphy.springbootlogin.service.UserService;

// 设置跨域请求
@CrossOrigin(origins = "http://localhost:8081",maxAge = 3600)
@RestController
@RequestMapping("/login")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public String login(@RequestBody User user) {
        User queryUser = userService.getUsernameAndPassword(user);
        // 查询失败，没有此用户
        if (queryUser == null) {
            return "failed";
        }
        // 查询成功
        return "success";
    }
}
