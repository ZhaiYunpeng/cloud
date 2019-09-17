package cn.zhaiyp.consumer.remote.hystrix;

import cn.zhaiyp.consumer.remote.HelloRemote;
import org.springframework.stereotype.Component;

@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(String msg) {
        return "hello," + msg +", this message send failed ";
    }

    @Override
    public String hello2(String msg) {
        return "hello2," + msg +", this message send failed ";
    }
}
