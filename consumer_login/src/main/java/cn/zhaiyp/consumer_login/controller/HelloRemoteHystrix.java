package cn.zhaiyp.consumer_login.controller;

import org.springframework.stereotype.Component;

@Component
public class HelloRemoteHystrix implements HelloRemote {
    @Override
    public String hello(String msg) {
        return "hello" + msg +", this message send failed ";
    }
}
