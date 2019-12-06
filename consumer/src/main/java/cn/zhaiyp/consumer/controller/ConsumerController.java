package cn.zhaiyp.consumer.controller;

import cn.zhaiyp.consumer.remote.HelloRemote;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "cloud", tags = "springCloud远程调用测试示例")
public class ConsumerController {

    @Autowired
    private HelloRemote helloRemote;

    @ApiOperation(value = "/hello/{msg}", notes = "测试1")
    @ApiImplicitParams(@ApiImplicitParam(name = "msg", value = "参数信息", dataType = "String", required=false, paramType="path"))
    @RequestMapping(value = "/hello/{msg}", method = RequestMethod.POST)
    public String index(@PathVariable("msg") String msg) {
        return helloRemote.hello(msg);
    }

    @ApiOperation(value = "/hello2/{msg}", notes = "测试2")
    @RequestMapping(value = "/hello2/{msg}", method = RequestMethod.POST)
    public String index2(@PathVariable("msg") String msg) {
        return helloRemote.hello2(msg);
    }
}
