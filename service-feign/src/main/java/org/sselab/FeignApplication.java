package org.sselab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
  * Created by xd031 on 2017/9/26.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
public class FeignApplication {
  public static void main(String[] args) {
    SpringApplication application = new SpringApplication(FeignApplication.class);
    application.run(args);
  }
}
//Ctrl+Shift+W 取消选择光标所在词
//CTRL+SHIRT+V:选择粘贴
//ctrl+H see the inheritance hierarchy for a selected class
//ctrl+q:context info
// ctrl+b:go to declaration(equal ctrl+click)
// ctrl+p:parameter info(within method call arguments)
