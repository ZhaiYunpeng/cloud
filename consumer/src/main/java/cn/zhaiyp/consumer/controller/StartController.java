package cn.zhaiyp.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fkptxmz
 */
@Controller
public class StartController {

    @RequestMapping("/login")
    public String getJsp() {
        System.out.println("test");
        return "index";
    }
}
