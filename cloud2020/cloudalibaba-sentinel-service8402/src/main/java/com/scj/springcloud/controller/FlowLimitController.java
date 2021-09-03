package com.scj.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-04 20:21
 */
@RestController
@Slf4j
public class FlowLimitController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping(value = "/testC")
    public String testFlowLimit()
    {
        return restTemplate.getForObject(serverUrl + "/testA", String.class);
    }

    @GetMapping(value = "/testD")
    public String testFlowLimit1()
    {
        return restTemplate.getForObject(serverUrl + "/testA", String.class);
    }
}
