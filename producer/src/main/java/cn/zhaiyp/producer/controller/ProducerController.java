package cn.zhaiyp.producer.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhaiyp
 */
@RestController
public class ProducerController {

    @Value("${neo.hello}")
    private String configStr;

    @RequestMapping("/hello/msg")
    @ResponseBody
    public String hello(@RequestParam String msg){
        return configStr + "This is producer hello,return msg is:"+msg;
    }

    @RequestMapping("/hello2/msg")
    @ResponseBody
    public String hello2(@RequestParam String msg){
        return configStr + "This is producer hello2,return msg is:"+msg;
    }
}
