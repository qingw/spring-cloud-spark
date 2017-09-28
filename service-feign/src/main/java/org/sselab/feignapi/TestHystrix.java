package org.sselab.feignapi;

import org.springframework.stereotype.Component;

/**
 * Created by xd031 on 2017/9/26.
 */
@Component
public class TestHystrix implements TestFeignInterface {

  @Override
  public String test(String name) {
    return "sorry error function! ";
  }

  @Override
  public DataSourceConfig getConfig() {
    return new DataSourceConfig("error", "error", "error", "error");
  }
}
