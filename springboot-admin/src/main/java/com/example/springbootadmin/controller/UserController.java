package com.example.springbootadmin.controller;

import com.example.springbootadmin.entity.User;
import com.example.springbootadmin.service.UserService;
import com.example.springbootadmin.vo.Page;
import org.apache.ibatis.annotations.Param;
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

    // Post: 添加数据
    @PostMapping
    public int addUser(@RequestBody User user) {
        // 默认密码
        if (user.getPassword() == null) {
            user.setPassword("12345");
        }
        // 默认信息
        if (user.getNickname() == null) {
            user.setNickname("");
        }
        if (user.getAge() == null) {
            user.setAge("0");
        }
        if (user.getSex() == null) {
            user.setSex("");
        }
        if (user.getAddress() ==null) {
            user.setAddress("");
        }
        return userService.addUser(user);
    }

    // GET: 分页查询
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

    // PUT: 更新数据
    @PutMapping
    public int updateUserById(@RequestBody User user) {
        return userService.updateUserById(user);
    }

    // delete：删除数据
    @DeleteMapping("/{id}")
    public int deleteUserById(@PathVariable("id") int id) {
        return userService.deleteUserById(id);
    }

    // post登录
    @PostMapping("/login")
    public int login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        User queryUser = userService.login(username, password);
        System.out.println(queryUser);
        System.out.println(username);
        System.out.println(password);
        if (queryUser == null) {
            return 1;
        }
        return 0;
    }

    ;

    // post 注册
    @PostMapping("/register")
    public int register(@RequestBody User user) {

        // 默认密码
        if (user.getPassword() == null) {
            user.setPassword("12345");
        }
        // 检查用户名是否重复
        if (userService.find(user.getUsername()) != null) {
            // 用户名重复，不能注册，返回 2
            return 2;
        }

        return addUser(user);

    }
}
