package cn.zhaiyp.consumer.controller;

import cn.zhaiyp.consumer.config.PropertiesConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : Administrator
 * @date : 2019/9/15
 */
public class BaseController {

    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private PropertiesConfig propertiesConfig;

    public String threadTest(String str){
        String returnStr = "线程" + str + "启动";
        logger.info(returnStr);
        return returnStr;
    }
}
