package com.kelan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by xd031 on 2017/9/26.
 */
@SpringBootApplication
//@EnableDiscoveryClient
public class Client1Application {
    public static void main(String[] args) {
        SpringApplication application=new SpringApplication(Client1Application.class);
        application.run();
    }
}
