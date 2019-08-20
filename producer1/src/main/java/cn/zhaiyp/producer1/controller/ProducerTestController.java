package cn.zhaiyp.producer1.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaiyp
 */
@RestController
public class ProducerTestController {

    @RequestMapping("/msg")
    @ResponseBody
    public String hello(@RequestParam String msg){
        return "This is producer1,return msg is:"+msg;
    }
}
