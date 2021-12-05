package com.example.springbootadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 把Mapper里的东西注入到Spring里面
// 添加扫描路径，告知接口在什么地方
@MapperScan("com/example/springbootadmin/mapper")
public class SpringbootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAdminApplication.class, args);
    }

}
