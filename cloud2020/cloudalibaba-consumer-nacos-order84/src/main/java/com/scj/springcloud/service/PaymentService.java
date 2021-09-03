package com.scj.springcloud.service;

import com.scj.springcloud.entites.CommonResult;
import com.scj.springcloud.entites.Payment;
import com.scj.springcloud.service.Impl.PaymentServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-07 19:52
 */
@Component
@FeignClient(value = "nacos-payment-provider", fallback= PaymentServiceImpl.class)  //由feign去调用的微服务名字
public interface PaymentService {

    @GetMapping(value = "/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}
