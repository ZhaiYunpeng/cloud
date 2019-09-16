package cn.zhaiyp.consumer.controller;

import cn.zhaiyp.consumer.config.WebSocketComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author : Administrator
 * @date : 2019/9/16
 */
@Controller
@RequestMapping("/checkCenter")
public class WebSocketController {

    @Autowired
    private WebSocketComponent webSocketComponent;

    /**
     *  页面请求
     */
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView("/webSocketTest");
        mav.addObject("cid", cid);
        return mav;
    }
    /**
     *  推送数据接口
     */
    @RequestMapping("/socket/push/{cid}")
    public void pushToWeb(@PathVariable String cid,String message) {
        try {
            WebSocketComponent.sendInfo(message,cid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
