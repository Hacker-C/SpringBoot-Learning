package top.mphy.blog.springbootapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.mphy.blog.springbootapi.entity.User;
import top.mphy.blog.springbootapi.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

// !控制层 控制业务逻辑
// *Controller层负责具体的业务模块流程的控制，
// *controller层负责前后端交互，接受前端请求，调用service层，接收service层返回的数据，
// *最后返回具体的页面和数据到客户端。
// controller包提供对外接口，调用mapper中的查询等操作
// RestController：所有查询的数据都会被渲染成JSON
@RestController
@RequestMapping("/user")
public class UserController {
    // 声明了某个变量但是未赋值时使用这个注解
    @Autowired
    private UserService userService;

    // *get请求：获取所有用户数据
    @GetMapping("/all")
    public List<User> getUser() {
        return userService.findAll();
    }

    // *get请求：根据用户id获取指定用户数据
    // *RESTfull风格
    @GetMapping("/{id}")
    public List<User> getUserInfoById(@PathVariable("id") int id) {
        return userService.getUserInfoById(id);
    }
//    public List<User> getUserInfoById(HttpServletRequest request) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        return userService.getUserInfoById(id);
//    }

    // *post请求：添加用户
    @PostMapping()
    // @RequestBody：把前端传过来的JSON包装成实体
    public String addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // *put请求：修改用户数据
    @PutMapping()
    public String updateById(@RequestBody User user) {
        return userService.updateById(user);
    }

    // *delete请求：删除用户数据
    // *RESTfull风格
    // {id}是占位符，接口示例：http://127.0.0.1:8080/user/6
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") int id) {
        return userService.deleteById(id);
    }

}
