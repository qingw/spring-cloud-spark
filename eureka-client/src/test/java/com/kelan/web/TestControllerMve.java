package com.kelan.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * web层得单元测试,可惜已经做了集成.下次一定写完全.
 * 使用 @WebMvcTest
 注解时，只有一部分的 Bean 能够被扫描得到，它们分别是：

 @Controller
 @ControllerAdvice
 @JsonComponent
 Filter
 WebMvcConfigurer
 HandlerMethodArgumentResolver
 其他常规的 @Component
 （包括 @Service
 、 @Repository
 等）Bean 则不会被加载到 Spring 测试环境上下文中
 */
@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class TestControllerMve {
  @Autowired
  private MockMvc mvc;

  @Test
  public void config() throws Exception {
    ResultActions perform = mvc.perform(get("/config"));
    perform.andExpect(status().isOk());
    perform.andDo(print());
    MvcResult result = perform.andReturn();
    System.out.println(result);
  }

  @Test
  public void sourceConfig() throws Exception {
  }

  @Test
  public void deleteDataSource() throws Exception {
  }
}
