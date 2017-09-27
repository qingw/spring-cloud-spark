package org.sselab;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by xd031 on 2017/9/26.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(EurekaApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }
}
