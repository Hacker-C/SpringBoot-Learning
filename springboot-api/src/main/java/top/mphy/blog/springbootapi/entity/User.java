package top.mphy.blog.springbootapi.entity;

// *entity：存放实体，比如用户的基本数据，根据数据库表中的内容设置

// *lombok：简化代码，不用生成getter和setter
import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String address;
    private int age;
    private String sex;
    private String phone;
}
