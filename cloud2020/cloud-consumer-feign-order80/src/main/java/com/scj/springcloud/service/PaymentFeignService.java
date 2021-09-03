package com.scj.springcloud.service;

import com.scj.springcloud.entites.CommonResult;
import com.scj.springcloud.entites.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-26 22:31
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //在eureka上寻找哪个微服务来调用
public interface PaymentFeignService {
    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();
}
