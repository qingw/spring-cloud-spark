package com.kelan.web;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * Created by xd031 on 2017/9/27.
 * spring.datasource.driver-class-name=com.mysql.jdbc.Driver
 * spring.datasource.password=password
 * spring.datasource.url=jdbc:mysql://DEVIP:PORT/DBNAME?characterEncoding=UTF-8
 * spring.datasource.username=username
 */
@RefreshScope
@Data
public class DataSourceConfig {
  @Value("spring.datasource.driver-class-name")
  private String driver;
  @Value("spring.datasource.password")
  private String password;
  @Value("spring.datasource.url")
  private String url;
  @Value("spring.datasource.username")
  private String username;
}
