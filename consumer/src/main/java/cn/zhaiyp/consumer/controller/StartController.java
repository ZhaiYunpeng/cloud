package cn.zhaiyp.consumer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fkptxmz
 */
@RestController
public class StartController {

    @RequestMapping("/login")
    @ResponseBody
    public String getJsp() {
        System.out.println("test");
        return "index";
    }
}
