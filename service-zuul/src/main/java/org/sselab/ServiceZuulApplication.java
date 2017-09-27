package org.sselab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by xd031 on 2017/9/27.
 * zuul不仅只是路由，并且还能过滤，做一些安全验证
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ServiceZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceZuulApplication.class, args);
    }
}
