package com.example.springbootadmin.entity;


import lombok.Data;

@Data
public class User {
    private int id;
    private  String username;
    private  String password;
    private  String nickname;
    private  String age;
    private  String sex;
    private  String address;
}
