# springboot 登录接口

练习使用springboot写一个简单的登录接口  
使用 RESTful 风格  
- 请求方式：POST
- 请求地址：localhost:8080/login
- 前端请求参数：
    ```
    {
       username: 'xxx',
       password: 'xxx' 
    }
    ```
- 后端返回：  
  - `'success'`：登录成功
  - `failed`：登录失败
  