package cn.zhaiyp.producer.controller;


import org.springframework.web.bind.annotation.*;

/**
 * @author zhaiyp
 */
@RestController
public class ProducerTestController {

    @RequestMapping("/msg")
    @ResponseBody
    public String hello(@RequestParam String msg){
        return "This is producer,return msg is:"+msg;
    }
}
