package top.mphy.springbootlogin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 把mapper包注入到springboot
@MapperScan("top/mphy/springbootlogin/mapper")
public class SpringbootLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLoginApplication.class, args);
    }

}
