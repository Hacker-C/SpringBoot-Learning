### SpringBoot 各层业务逻辑
```
Controller-->service接口-->serviceImpl-->dao接口-->daoImpl-->mapper-->db
```
在具体的项目中，其流程为：Controller层调用Service层的方法，Service层调用Dao层中的方法，其中调用的参数是使用Entity层进行传递的。总的来说这样每层做什么的分类只是为了使业务逻辑更加清晰，写代码更加方便，所以有时候也需要根据具体情况来，但是大体的都是这样处理的，因为它其实就是提供一种规则，让你把相同类型的代码放在一起，这样就形成了层次，从而达到分层解耦、复用、便于测试和维护的目的。

### Spring boot简单步骤

1. 建立实体类，跟数据库表字段保持一致
2. 建立mapper接口，写具体的sql语句，以及这个SQL语句要定义要操作数据库的动作 
4. 建立service类，处理业务逻辑
5. 在controller类中展示处理的结果

### 增删改查

- 增：`POST`
- 删：`DELETE`
- 改：`PUT`
- 查：`GET`

### 动态SQL

要在带注解的映射器接口类中使用动态 SQL，可以使用 script 元素。比如:
```java
@Update({"<script>",
  "update Author",
  "  <set>",
  "    <if test='username != null'>username=#{username},</if>",
  "    <if test='password != null'>password=#{password},</if>",
  "    <if test='email != null'>email=#{email},</if>",
  "    <if test='bio != null'>bio=#{bio}</if>",
  "  </set>",
  "where id=#{id}",
  "</script>"})
void updateAuthorValues(Author author);
```
