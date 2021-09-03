package com.scj.springcloud.contriller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-26 17:49
 */
@RestController
@Slf4j
public class OrderController {

    public static final String INVOKE_URL = "http://cloud-provider-payment";//以微服务名字去调用微服务

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/consul")
    public String paymentInfo()
    {
        String result = restTemplate.getForObject(INVOKE_URL +"/payment/consul",String.class);
        return result;
    }

}
