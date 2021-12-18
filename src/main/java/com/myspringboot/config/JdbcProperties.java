package com.myspringboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ConfigurationProperties 从配置文件中读取配置项
 * prefix表示配置项的前缀
 * 配置类中的变量名必须与配置前缀之后的配置项名称 保持松散绑定
 */
@ConfigurationProperties(prefix = "jdbc")
public class JdbcProperties {
  private String driver;
  private String url;
  private String username;
  private String password;

  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
