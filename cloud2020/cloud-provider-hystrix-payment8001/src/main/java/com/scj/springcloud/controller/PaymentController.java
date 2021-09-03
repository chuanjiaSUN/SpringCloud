package com.scj.springcloud.controller;

import com.scj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-27 21:19
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @Value("${server.port}")
    private String serverPort;

    // ==================== 服务降级

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentInfo(id);
        log.info("********result +" + result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("*********result " + result);
        return result;
    }

    // ==================== 服务熔断
    @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("************result: " + result);
        return result;
    }

}
