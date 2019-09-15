package cn.zhaiyp.consumer.test;

import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @date : 2019/9/14
 */
//@Component
public class TicketSale implements Runnable {
    /**
     * 门票销售窗口编号
     */
    private  String ticketName;

    /**
     * 门票总张数
     */
    private static int ticketCount = 50;

    public TicketSale(String ticketName) {
        this.ticketName = ticketName;
    }

    public  String saleTicket(){
        String returnStr = null;
        while (ticketCount > 0) {
            returnStr = "窗口" + ticketName + "售出第：" + (50 - ticketCount + 1) + "张票；";
            ticketCount --;
        }
        return returnStr;
    }

    @Override
    public void run() {
        while (ticketCount > 0) {
            System.out.println("窗口" + ticketName + "售出第：" + (50 - ticketCount + 1) + "张票；");
            ticketCount --;
        }
    }
}
