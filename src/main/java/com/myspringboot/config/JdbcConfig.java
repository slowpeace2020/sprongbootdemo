package com.myspringboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@PropertySource("classpath:application.yml")
//@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig {

//  @Value("${jdbc.url}")
//  private String url;
//  @Value("${jdbc.driverClassName}")
//  private String driver;
//  @Value("${jdbc.username}")
//  private String username;
//  @Value("${jdbc.password}")
//  private String password;
//
//  @Bean
//  public DataSource dataSource(){
//    DruidDataSource dataSource = new DruidDataSource();
//    dataSource.setDriverClassName(driver);
//    dataSource.setUrl(url);
//    dataSource.setUsername(username);
//    dataSource.setPassword(password);
//    return dataSource;
//  }


//    @Bean
//  public DataSource dataSource(JdbcProperties jdbcProperties){
//    DruidDataSource dataSource = new DruidDataSource();
//    dataSource.setDriverClassName(jdbcProperties.getDriver());
//    dataSource.setUrl(jdbcProperties.getUrl());
//    dataSource.setUsername(jdbcProperties.getUsername());
//    dataSource.setPassword(jdbcProperties.getPassword());
//    return dataSource;
//  }

  @Bean
  @ConfigurationProperties(prefix = "jdbc")
  public DataSource dataSource(){
    return new DruidDataSource();
  }


}
