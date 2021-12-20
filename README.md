
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


## 5. 多个yml文件配置

**目标**：可以将多个yml文件在application.yml文件中配置激活

**分析**：

yaml与properties配置文件除了展示形式不相同以外，其它功能和作用都是一样的；在项目中原路的读取方式不需要改变。

1）yml配置文件的特征：

1. 树状层级结构展示配置项；
2. 配置项之间如果有关系的话需要分行空两格；
3. 配置项如果有值的话，那么需要在 `:`之后空一格再写配置项值；

将application.properties配置文件修改为application.yml的话：

2）多个yml配置文件；在spring boot中是被允许的。这些配置文件的名称必须为application-***.yml，并且这些配置文件必须要在application.yml配置文件中激活之后才可以使用。



3）如果properties和yml配置文件同时存在在spring boot项目中；那么这两类配置文件都有效。在两个配置文件中如果存在同名的配置项的话会以properties文件的为主。



**小结**：

在多个配置文件时，需要将这些文件在application.yml文件中进行激活：

## 6. 自动配置原理

**目标**：了解Spring Boot项目的配置加载流程

**小结**：

- 在 `META-INF\spring.fatories`文件中定义了很多自动配置类；可以根据在pom.xml文件中添加的 启动器依赖自动配置组件
- 通过如下流程可以去修改application配置文件，改变自动配置的组件默认参数

![spring修改配置](mdimg/spring修改配置.png)


## 7. lombok应用

**目标**：使用lombok的注解实现pojo类的简化

**分析**：

使用Spring Boot整合SSM工程；需要使用到数据库数据。

- 将数据库表数据导入到数据库中（springboot_test）；

- 编写数据库表对应的实体类；一般情况下需要编写get/set/toString等这些方法会耗时并且会让实体类看起来比较臃肿。可以使用lombok插件对实体类进行简化。

  lombok是一个插件工具类包；提供了一些注解@Data、@Getter等这些注解去简化实体类中的构造方法、get/set等方法的编写。

  1. 在IDEA中安装lombok插件；
  2. 添加lombok对应的依赖到项目pom.xml文件；
  3. 改造实体类使用lombok注解

**小结**：

在Bean上使用：
@Data ：自动提供getter和setter、hashCode、equals、toString等方法
@Getter：自动提供getter方法
@Setter：自动提供setter方法
@Slf4j：自动在bean中提供log变量，其实用的是slf4j的日志功能。

## 8. Spring Boot整合-SpringMVC端口和静态资源

**目标**：可以修改tomcat的端口和访问项目中的静态资源

**分析**：

- 修改tomcat端口

  查询**Properties，设置配置项（前缀+类变量名）到application配置文件中

- 访问项目中的静态资源

  静态资源放置的位置；放置静态资源并访问这些资源

**小结**：

- 修改项目tomcat端口：

```yml
#tomcat端口
server:
  port: 80
```

- 在spring boot项目中静态资源可以放置在如下目录：
```
@ConfigurationProperties(
    prefix = "spring.resources",
    ignoreUnknownFields = false
)
public class ResourceProperties {
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = new String[]{"classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/"};
    private String[] staticLocations;
    }
```

## 9.Spring Boot整合-SpringMVC拦截器

**目标**：可以在Spring Boot项目中配置自定义SpringMVC拦截器

**分析**：

1. 编写拦截器（实现HandlerInterceptor）；
2. 编写配置类实现 WebMvcConfigurer，在该类中添加各种组件；
3. 测试

**小结**：

可以在spring boot项目中通过配置类添加各种组件；如果要添加拦截器的话：


