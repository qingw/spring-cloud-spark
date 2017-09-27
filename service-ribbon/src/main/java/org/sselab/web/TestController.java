package org.sselab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sselab.service.TestService;

/**
 * Created by xd031 on 2017/9/26.
 */
@RestController
public class TestController {
    @Autowired
    TestService service;

    @GetMapping("/hello")
    public String test(@RequestParam String name) {
        return service.hiService(name);
    }
}
