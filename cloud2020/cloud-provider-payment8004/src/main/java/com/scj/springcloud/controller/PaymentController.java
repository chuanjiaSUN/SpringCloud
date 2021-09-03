package com.scj.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-25 12:01
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentZk()
    {
        return "springCloud with zookeeper: " + serverPort +"\t" + UUID.randomUUID().toString();
    }

}
