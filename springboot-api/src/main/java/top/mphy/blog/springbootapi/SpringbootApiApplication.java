package top.mphy.blog.springbootapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// SpringBoot项目引导类（启动类）
@SpringBootApplication
// 把Mapper里的东西注入到Spring里面
// 添加扫描路径，告知接口在什么地方
@MapperScan("top/mphy/blog/springbootapi/mapper")
public class SpringbootApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApiApplication.class, args);
    }

}
