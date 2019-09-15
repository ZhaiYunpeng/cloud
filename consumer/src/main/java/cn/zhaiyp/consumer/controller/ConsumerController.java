package cn.zhaiyp.consumer.controller;

import cn.zhaiyp.consumer.remote.HelloRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private HelloRemote helloRemote;

    @RequestMapping("/hello/{msg}")
    public String index(@PathVariable("msg") String msg) {
        return helloRemote.hello(msg);
    }
}
