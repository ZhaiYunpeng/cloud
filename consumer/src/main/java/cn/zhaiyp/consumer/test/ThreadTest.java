package cn.zhaiyp.consumer.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Administrator
 */
public class ThreadTest {
    public static void main(String[] args) {
        threadStart();
    }

    public static void threadStart(){
        int taskSize = 5;
        final CountDownLatch countDownLatch = new CountDownLatch(taskSize);
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        List<Future> listFuture = new ArrayList<>();
        for (int i = 0; i < taskSize; i++) {
            TicketSale ticketSale = new TicketSale(String.valueOf(i + 1));
//            pool.submit(ticketSale);
            listFuture.add(pool.submit(ticketSale));
            System.out.println("线程" + (i + 1) + "启动！");
            countDownLatch.countDown();
        }
//        try {
//            // 阻塞当前线程，直到线程全部完成
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("线程全部完成！");
    }
}
