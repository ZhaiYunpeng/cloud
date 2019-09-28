package cn.zhaiyp.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigTestController {
    @Value("${neo.hello}")
    private String configStr;

    @RequestMapping("/hello")
    public String from() {
        return this.configStr;
    }
}
