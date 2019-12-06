package cn.zhaiyp.consumer.remote;

import cn.zhaiyp.consumer.remote.hystrix.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fkptxmz
 * 远程调用
 */
@FeignClient(name = "producer", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {
    @RequestMapping(value = "/hello/msg")
    String hello(@RequestParam String msg);

    @RequestMapping(value = "/hello2/msg")
    String hello2(@RequestParam String msg);
}
