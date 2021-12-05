package com.example.springbootadmin.controller;

import com.example.springbootadmin.entity.User;
import com.example.springbootadmin.service.UserService;
import com.example.springbootadmin.vo.Page;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        // 默认密码
        if (user.getPassword() == null) {
            user.setPassword("12345");
        }
        return userService.addUser(user);
    }

    @GetMapping
    public Page<User> findByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "") String key) {
        int offset = (pageNum - 1) * pageSize;
        List<User> userData = userService.findByPage(offset, pageSize, key);
        Page<User> page = new Page<>();
        page.setData(userData);
        int total = userService.countUser();
        page.setTotal(total);
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        return page;
    }

}
