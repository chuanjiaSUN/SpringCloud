package com.scj.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.scj.springcloud.entites.CommonResult;
import com.scj.springcloud.entites.Payment;
import com.scj.springcloud.myHandler.CustomerBlockHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-04 21:53
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource()
    {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    public CommonResult handleException(BlockException exception)
    {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可调用");
    }

    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl()
    {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    @GetMapping("/rateLimit/customerHandler")
    @SentinelResource(value = "customerHandler", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerExcetion1")
    public CommonResult customerBlockHandler()
    {
        return new CommonResult(200, "按客户自定义，", new Payment(2020L, "serial002"));
    }

}
