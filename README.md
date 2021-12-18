
> Spring Boot是一个便捷搭建 基于spring工程的脚手架；作用是帮助开发人员快速搭建大型的spring 项目。简化工程的配置，依赖管理；实现开发人员把时间都集中在业务开发上。

需求：可以在浏览器中访问http://localhost:8080/hello输出一串字符

实现步骤：

1. 创建工程；
2. 添加依赖（启动器依赖，spring-boot-starter-web）；
3. 创建启动类；
4. 创建处理器Controller；
5. 测试

**小结**：

Spring Boot工程可以通过添加启动器依赖和创建启动引导类实现快速创建web工程。
* springboot工程都有一个启动引导类，为工程的入口类,在类上添加@SpringBootApplication
  注解
> spring-boot-starter-web默认的应用服务器端口是8080

Spring的Java配置方式是通过 @Configuration 和 @Bean 这两个注解实现的：
1、@Configuration 作用于类上，相当于一个xml配置文件；
2、@Bean 作用于方法上，相当于xml配置中的<bean>；