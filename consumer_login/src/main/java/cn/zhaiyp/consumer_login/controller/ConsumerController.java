package cn.zhaiyp.consumer_login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    HelloRemote HelloRemote;

    @RequestMapping("/hello/{msg}")
    public String index(@PathVariable("msg") String msg) {
        return HelloRemote.hello(msg);
    }
}
