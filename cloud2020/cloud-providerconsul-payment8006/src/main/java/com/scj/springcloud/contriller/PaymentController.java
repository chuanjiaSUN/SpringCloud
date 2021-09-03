package com.scj.springcloud.contriller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-26 17:30
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentConsul()
    {
        return "springCloud with consul: " + serverPort +"\t"+ UUID.randomUUID().toString();
    }
}
