package org.sselab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by xd031 on 2017/9/27.
 * rabbitMQ: http://localhost:15672   name:guest  password:guest
 * http://localhost:port/from
 * http://localhost:port/refresh
 * http://localhost:port/bus/refresh
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
  public static void main(String[] args) {
    new SpringApplicationBuilder(ConfigServerApplication.class).web(true).run(args);
  }
}
