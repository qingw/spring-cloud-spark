package com.kelan.web;

import com.google.gson.Gson;
import com.kelan.Client1Application;
import com.kelan.entity.DataSourceConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 集成测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Client1Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestControllerTest {
  public static final String URL = "/config";
  @Value("${local.server.port}")
  private int port;
  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private MockMvc mvc;

//  @MockBean
//  private TestService testService;

  /**
   * test gson
   *
   * @throws Exception
   */
  @Test
  public void test() throws Exception {
    DataSourceConfig result = new DataSourceConfig("com.mysql.jdbc.Driver", "password123456", "jdbc:mysql://DEVIP:PORT/DBNAME?characterEncoding=UTF-8", "username123456", "0");
    String expected = "{\"driver\":\"com.mysql.jdbc.Driver\",\"password\":\"password123456\",\"url\":\"jdbc:mysql://DEVIP:PORT/DBNAME?characterEncoding=UTF-8\",\"username\":\"username123456\",\"port\":\"0\"}";
    String unexpected = "{\"driver\":\"com.mysql.jdbc.Driver\",\"password\":\"password123456\",\"url\":\"jdbc:mysql://DEVIP:PORT/DBNAME?characterEncoding\\u003dUTF-8\",\"username\":\"username123456\",\"port\":\"0\"}";
    assertNotEquals(expected, new Gson().toJson(result));
    assertEquals(unexpected, new Gson().toJson(result));
  }

  /**
   * GET
   *
   * @throws Exception
   */
  @Test
  public void configWithRestForGet() throws Exception {
//    when(testService.getConfig()).thenReturn(new DataSourceConfig("test-driver", "test-pwd", "test-url", "test-name", port + ""));
    DataSourceConfig result = restTemplate.getForObject(URL, DataSourceConfig.class);
    String expected = "{\"driver\":\"com.mysql.jdbc.Driver\",\"password\":\"password123456\",\"url\":\"jdbc:mysql://DEVIP:PORT/DBNAME?characterEncoding=UTF-8\",\"username\":\"username123456\",\"port\":\"0\"}";
    String actual = new Gson().toJson(result).replace("\\u003d", "=");
    JSONAssert.assertEquals(expected, actual, false);
  }


  /**
   * 不能确定是否是json格式
   *
   * @throws Exception
   */
  @Test
  public void configWithMVCForGet() throws Exception {
//    when(testService.getConfig()).thenReturn(new DataSourceConfig("test-driver", "test-pwd", "test-url", "test-name", port + ""));
    MvcResult result = mvc.perform(get(URL))
      .andExpect(status().isOk())
      .andDo(print())
      .andReturn();
    String expected = "{\"driver\":\"com.mysql.jdbc.Driver\",\"password\":\"password123456\",\"url\":\"jdbc:mysql://DEVIP:PORT/DBNAME?characterEncoding=UTF-8\",\"username\":\"username123456\",\"port\":\"0\"}";
    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
  }


  /**
   * POST
   *
   * @throws Exception
   */
  @Test
  public void dataSourceConfigWithMVCForPost() throws Exception {
    DataSourceConfig dataSource = new DataSourceConfig("mvc", "mvc", "mvc", "mvc", "mvc");
    RequestBuilder request = post(URL)
      .content(new Gson().toJson(dataSource))
      .accept(MediaType.APPLICATION_JSON_UTF8)
      .contentType(MediaType.APPLICATION_JSON_UTF8);
    MvcResult result = mvc.perform(request)
      .andExpect(status().isOk())
      .andDo(print())
      .andReturn();
    String expected = "[{driver:\"mvc\",password:\"mvc\",url:\"mvc\",username:\"mvc\",port:\"mvc\"},{driver:\"com.mysql.jdbc.Driver\",password:\"password123456\",url:\"jdbc:mysql://DEVIP:PORT/DBNAME?characterEncoding=UTF-8\",username:\"username123456\",port:\"0\"}]";
    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);//pass
    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);//pass
    expected = "[{driver:\"com.mysql.jdbc.Driver\",password:\"password123456\",url:\"jdbc:mysql://DEVIP:PORT/DBNAME?characterEncoding=UTF-8\",username:\"username123456\",port:\"0\"},{driver:\"mvc\",password:\"mvc\",url:\"mvc\",username:\"mvc\",port:\"mvc\"}]";
    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);//pass
//    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);//fail

    expected = "[{password:\"mvc\"},{driver:\"com.mysql.jdbc.Driver\"}]";
//    JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),true);//fail
    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);//pass

    expected = "[{password:\"mvc\",driver:\"mvc\",url:\"mvc\",username:\"mvc\",port:\"mvc\"},{password:\"password123456\",driver:\"com.mysql.jdbc.Driver\",url:\"jdbc:mysql://DEVIP:PORT/DBNAME?characterEncoding=UTF-8\",username:\"username123456\",port:\"0\"}]";
    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);//pass
    JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), true);//pass
  }

  @Test
  public void dataSourceConfigWithRestForPost() throws Exception {
    DataSourceConfig dataSource = new DataSourceConfig("hs", "hs", "hs", "hs", "hs");
    DataSourceConfig[] dataSourceConfigs = restTemplate.postForObject(URL, dataSource, DataSourceConfig[].class);
    List<DataSourceConfig> actual = Arrays.asList(dataSourceConfigs);
    List<DataSourceConfig> expected = Arrays.asList(dataSource, new DataSourceConfig("com.mysql.jdbc.Driver", "password123456", "jdbc:mysql://DEVIP:PORT/DBNAME?characterEncoding=UTF-8", "username123456", "0"));
    assertThat(actual, is(expected));
    assertThat(actual, hasSize(2));
    assertThat(actual, hasItem(dataSource));
  }


  @Test
  public void testConfigWithMVCForPut() throws Exception {
    DataSourceConfig dataSource = new DataSourceConfig("hs", "hs", "hs", "hs", "hs");
    RequestBuilder request = put(URL)
      .content(new Gson().toJson(dataSource))
      .contentType(MediaType.APPLICATION_JSON_UTF8);
    mvc.perform(request)
      .andExpect(status().is2xxSuccessful());
  }

  @Test
  public void testConfigWithRestForPut() throws Exception {
    DataSourceConfig dataSource = new DataSourceConfig("hs", "hs", "hs", "hs", "hs");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
    HttpEntity<DataSourceConfig> entity = new HttpEntity<DataSourceConfig>(dataSource, headers);
    HttpStatus statusCode = restTemplate.exchange(URL, HttpMethod.PUT, entity, Object.class).getStatusCode();
    assertTrue(statusCode.is2xxSuccessful());
  }

  @Test
  public void testConfigWithMVCForDelete() throws Exception {
    DataSourceConfig dataSource = new DataSourceConfig("mvc", "mvc", "mvc", "mvc", "mvc");
    RequestBuilder request = delete(URL)
      .content(new Gson().toJson(dataSource))
      .contentType(MediaType.APPLICATION_JSON_UTF8)
      .param("id","\"2\"");
    mvc.perform(request)
      .andExpect(status().is2xxSuccessful());
  }

  @Test
  public void testConfigWithRestForDelete() throws Exception {
    DataSourceConfig dataSource = new DataSourceConfig("hs", "hs", "hs", "hs", "hs");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
    HttpEntity<DataSourceConfig> entity = new HttpEntity<DataSourceConfig>(dataSource, headers);
    Map<String, String> params = new HashMap<>();
    params.put("id", "1");
    System.out.println(restTemplate.exchange(URL, HttpMethod.DELETE, entity, Object.class,params).getBody());
    System.out.println(restTemplate.exchange(URL, HttpMethod.DELETE, entity, Object.class,"1").getBody());
    HttpStatus status = restTemplate.exchange(URL+"?id=\"1\"", HttpMethod.DELETE, entity, Object.class).getStatusCode();
    assertTrue(status.is2xxSuccessful());
  }
  @Test
  public void testConfigWithRestForDelete1() throws Exception {
    DataSourceConfig dataSource = new DataSourceConfig("hs", "hs", "hs", "hs", "hs");
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
    HttpEntity<DataSourceConfig> entity = new HttpEntity<DataSourceConfig>(dataSource, headers);
    System.out.println(restTemplate.exchange(URL+"/{id}", HttpMethod.DELETE, entity, Object.class,"1").getBody());
  }
}
