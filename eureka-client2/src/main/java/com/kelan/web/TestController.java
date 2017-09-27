package com.kelan.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xd031 on 2017/9/26.
 */
@RestController
public class TestController {
    @Value("${server.port}")
    public String port;

    @GetMapping("/hello")
    public String test(@RequestParam String name) {
        return "hello" + name + "->" + port;
    }
}
