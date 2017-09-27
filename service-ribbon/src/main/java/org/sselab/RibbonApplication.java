package org.sselab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by xd031 on 2017/9/26.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(RibbonApplication.class);
        application.run(args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
