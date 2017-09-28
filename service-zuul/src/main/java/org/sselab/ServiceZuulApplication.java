package org.sselab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by xd031 on 2017/9/27.
 * zuul不仅只是路由，并且还能过滤，做一些安全验证
 * serviceId的映射方式，除了对Zuul维护上更加友好之外，serviceId映射方式
 * 还支持了断路器，对于服务故障的情况下，可以有效的防止故障蔓延到服务网关
 * 上而影响整个系统的对外服务
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ServiceZuulApplication {
  public static void main(String[] args) {
    SpringApplication.run(ServiceZuulApplication.class, args);
  }
}
