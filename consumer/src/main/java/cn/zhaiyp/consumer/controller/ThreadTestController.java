package cn.zhaiyp.consumer.controller;

import cn.zhaiyp.consumer.config.ExecutorConfig;
import cn.zhaiyp.consumer.service.ThreadServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : Administrator
 * @date : 2019/9/15
 */
@RestController
@RequestMapping("/thread")
public class ThreadTestController {

    @Autowired
    private ThreadServiceTest threadServiceTest;
    @Autowired
    private ThreadPoolTaskExecutor threadPoolA;


    @RequestMapping("/startThread")
    public String startThread() {
        String str = threadServiceTest.executeAsync("str");
        return str;
    }

    @RequestMapping("/saleTicket")
    public String saleTicket() {
        int wicketCount = 5;
        for (int i = 0; i < wicketCount; i++) {
            String wicketNum = String.valueOf(i + 1);
            threadPoolA.submit(new Runnable() {
                @Override
                public void run() {
                    Thread.currentThread().setName("t1");
                    while (true) {
                        if (threadServiceTest.getTotalTicket() > 0) {
                            threadServiceTest.saleTicket(wicketNum);
                            try {
                                Thread.sleep(1);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else {
                            break;
                        }

                    }

                }
            });
        }
        return null;
    }
}
