package cn.zhaiyp.producer.controller;


import org.springframework.web.bind.annotation.*;

/**
 * @author zhaiyp
 */
@RestController
public class ProducerController {

    @RequestMapping("/hello/msg")
    @ResponseBody
    public String hello(@RequestParam String msg){
        return "This is producer hello,return msg is:"+msg;
    }

    @RequestMapping("/hello2/msg")
    @ResponseBody
    public String hello2(@RequestParam String msg){
        return "This is producer hello2,return msg is:"+msg;
    }
}
