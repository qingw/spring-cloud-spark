package com.kelan.service;

import com.kelan.entity.DataSourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Service
@RefreshScope
public class TestService {
  @Value("${server.port}")
  public String port;
  @Value("${spring.datasource.driver-class-name}")
  private String driver;
  @Value("${spring.datasource.password}")
  private String password;
  @Value("${spring.datasource.url}")
  private String url;
  @Value("${spring.datasource.username}")
  private String username;
  public DataSourceConfig getConfig() {
    return new DataSourceConfig(driver, password, url, username, port);
  }
}
