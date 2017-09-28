package org.sselab.feignapi;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by xd031 on 2017/9/26.
 */
@FeignClient(value = "client", fallback = TestHystrix.class)
public interface TestFeignInterface {
  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public String test(@RequestParam(value = "name") String name);

  @RequestMapping(value = "/config", method = RequestMethod.GET)
  public DataSourceConfig getConfig();
}
