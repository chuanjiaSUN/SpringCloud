package com.scj.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-27 21:20
 */
public interface PaymentService {
    public String paymentInfo(Integer id);
    public String paymentInfo_Timeout(Integer id);
    public String paymentCircuitBreaker(Integer id);
}
