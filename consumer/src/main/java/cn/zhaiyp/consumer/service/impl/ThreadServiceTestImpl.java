package cn.zhaiyp.consumer.service.impl;

import cn.zhaiyp.consumer.service.ThreadServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author : Administrator
 * @date : 2019/9/15
 */
@Service
public class ThreadServiceTestImpl implements ThreadServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(ThreadServiceTestImpl.class);

    private static int totalTicket = 50;

    @Override
    @Async("threadPoolA")
    public String executeAsync(String str) {
        logger.info("start executeAsync" + str);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "executeAsync:" + str;
    }

    @Override
    public String saleTicket(String str) {
        String returnStr = null;
        synchronized (this) {
            if (totalTicket > 0) {
                returnStr = "窗口" + str + "卖了第" + totalTicket + "张票";
                totalTicket--;
            } else {
                returnStr = "--票卖完了！";
            }
        }
        logger.info(returnStr);
        return returnStr;
    }

    @Override
    public int getTotalTicket() {
        return totalTicket;
    }
}
