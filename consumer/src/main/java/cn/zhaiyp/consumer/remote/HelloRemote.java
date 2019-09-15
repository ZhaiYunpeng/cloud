package cn.zhaiyp.consumer.remote;

import cn.zhaiyp.consumer.remote.hystrix.HelloRemoteHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author fkptxmz
 */
@FeignClient(name = "producer", fallback = HelloRemoteHystrix.class)
public interface HelloRemote {
    @RequestMapping(value = "/msg")
    String hello(@RequestParam(value = "msg") String msg);
}