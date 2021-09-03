package com.scj.springcloud.service.Impl;

import com.scj.springcloud.service.PaymentFeignHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-29 16:22
 */

/*
*         统一做服务降级
* */
@Component
public class PaymentFallBackService implements PaymentFeignHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "-------PaymentFallbackService paymentInfo_ok fall back, /(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "-------PaymentFallbackService paymentInfoTimeout fall back, /(ㄒoㄒ)/~~";
    }
}
