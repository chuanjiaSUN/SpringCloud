package com.scj.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-25 17:13
 */
@RestController
@Slf4j
public class OrderZkController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";//以微服务名字去调用微服务

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/zk")
    public String paymentInfo()
    {
        String result = restTemplate.getForObject(INVOKE_URL +"/payment/zk",String.class);
        return result;
    }

}
