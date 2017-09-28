package org.sselab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xd031 on 2017/9/26.
 */
@Service
public class TestService {
  @Autowired
  RestTemplate restTemplate;

  public String hiService(String name) {
    return restTemplate.getForObject("http://CLIENT/hello?name=" + name, String.class);
  }

  public DataSourceConfig getConfig() {
    return restTemplate.getForObject("http://CLIENT/config", DataSourceConfig.class);
  }
}
