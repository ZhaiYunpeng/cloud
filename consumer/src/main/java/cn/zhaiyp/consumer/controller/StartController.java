package cn.zhaiyp.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fkptxmz
 */
@Controller
public class StartController {

    @ResponseBody
    @RequestMapping("/login")
    public String getJsp() {
        System.out.println("test");
        return "index";
    }
}
