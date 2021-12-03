package top.mphy.springbootlogin.entity;


import lombok.Data;

@Data
public class User {
    // 用户id
    private int id;
    // 用户名（登录名）
    private String username;
    // 用户昵称
    private String nickname;
    // 密登录码
    private String password;
}

