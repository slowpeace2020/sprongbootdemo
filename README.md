
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

```
@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {

  @Value("${jdbc.url}")
  private String url;
  @Value("${jdbc.driver}")
  private String driver;
  @Value("${jdbc.user}")
  private String user;
  @Value("${jdbc.password}")
  private String password;

  @Bean
  public DataSource dataSource(){
    DruidDataSource dataSource = new DruidDataSource();
    dataSource.setDriverClassName(driver);
    dataSource.setUrl(url);
    dataSource.setUsername(user);
    dataSource.setPassword(password);
    return dataSource;
  }

}
```

## 4. Spring Boot属性注入方式

**目标**：能够使用@ConfigurationProperties实现Spring Boot配置文件配置项读取和应用

**分析**：

需求：将配置文件中的配置项读取到一个对象中；

实现：可以使用Spring Boot提供的注解@ConfigurationProperties，该注解可以将Spring Boot的配置文件（默认必须为application.properties或application.yml）中的配置项读取到一个对象中。

实现步骤：

1. 创建配置项类JdbcProperties类，在该类名上面添加@ConfigurationProperties；
2. 将jdbc.properties修改名称为application.properties；
3. 将JdbcProperties对象注入到JdbcConfig；

