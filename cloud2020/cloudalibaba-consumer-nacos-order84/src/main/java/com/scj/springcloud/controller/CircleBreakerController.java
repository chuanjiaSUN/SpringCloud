package com.scj.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.scj.springcloud.entites.CommonResult;
import com.scj.springcloud.entites.Payment;
import com.scj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-07 15:31
 */
@RestController
@Slf4j
public class CircleBreakerController {

    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")// 没有配置
//    @SentinelResource(value = "fallback", fallback = "handlerFallback") // fallback只负责业务异常
//    @SentinelResource(value = "fallback", blockHandler = "blockHandler") // blockHandler只负责sentinel控制台配置违规
//    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")  // fallback与blockHandler都配置
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler",
    exceptionsToIgnore = {IllegalArgumentException.class}) // 假如报该异常，不再有fallback方法兜底，没有降级效果了
    public CommonResult<Payment> fallback(@PathVariable("id") Long id) {
        CommonResult result = restTemplate.getForObject(SERVICE_URL + "/paymentSql/" + id, CommonResult.class);

        if (id == 4) throw new IllegalArgumentException("IllegalArgument,非法参数");
        else if (result.getData() == null) throw new NullPointerException("NullPointerException,没有对应记录");
        else return result;
    }

    //本例是fallback
    public CommonResult handlerFallback(@PathVariable("id") Long id, Throwable e)
    {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "兜底异常handlerFallback, exception: " + e.getMessage(), payment);
    }

    //本例是blockhandler
    public CommonResult blockHandler(@PathVariable("id") Long id, BlockException blockException)
    {
        Payment payment = new Payment(id, "null");
        return new CommonResult(444, "blockHandler-sentinel 限流， 无此流水： blockException: " + blockException.getMessage(), payment);
    }

    //============OpenFeign


    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult paymentSql(@PathVariable("id") Long id)
    {
        return paymentService.paymentSql(id);
    }

}
