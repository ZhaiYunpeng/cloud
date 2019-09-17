package cn.zhaiyp.producer.service.impl;

import cn.zhaiyp.producer.service.ProducerService;
import org.springframework.stereotype.Service;

@Service
public class ProducerServerImpl implements ProducerService {
    @Override
    public String firstService(String msg) {
        return "This is second producer first service,return msg is:" + msg;
    }
    @Override
    public String secondService(String msg) {
        return "This is first producer second service,return msg is:" + msg;
    }
}
