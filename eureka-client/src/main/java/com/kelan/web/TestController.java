package com.kelan.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xd031 on 2017/9/26.
 */
@RestController
@RefreshScope
public class TestController {
  @Value("${server.port}")
  public String port;

  @Value("spring.datasource.driver-class-name")
  private String driver;
  @Value("spring.datasource.password")
  private String password;
  @Value("spring.datasource.url")
  private String url;
  @Value("spring.datasource.username")
  private String username;

  @GetMapping("/hello")
  public String test(@RequestParam String name) {
    return "hello" + name + "->" + port;
  }

  @GetMapping("/config")
  public DataSourceConfig config() {
    return new DataSourceConfig(driver, password, url, username);
  }
}
