package com.scj.springcloud.service;

import com.scj.springcloud.service.Impl.PaymentFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-27 21:50
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentFallBackService.class)
public interface PaymentFeignHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Integer id);
}
