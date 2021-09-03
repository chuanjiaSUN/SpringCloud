package com.scj.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-04 17:40
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA()
    {
        //暂停毫秒
//        try {
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        return "--------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "----------testB";
    }

    @GetMapping("/testD")
    public String testD()
    {
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        log.info("testD 测试 RT");
        return "**********testD";
    }

    @GetMapping("/testE")
    public String testE()
    {
        log.info("测试异常比例");
        int a = 10 / 0;
        return "*********testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealTestHotKey")  // 唯一标识
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2)
    {
        return "_______________testHotKey";
    }

    public String dealTestHotKey(String p1, String p2, BlockException exception)
    {
        return "_______________dealTestHotKey,/(ㄒoㄒ)/~~";

    }
}
