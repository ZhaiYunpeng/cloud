package cn.zhaiyp.consumer.service;

/**
 * @author : Administrator
 * @date : 2019/9/15
 */
public interface ThreadServiceTest {
    /**
     * 执行异步任务
     */
    String executeAsync(String str);

    String saleTicket(String str);

    int getTotalTicket();
}
