package com.scj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-04 20:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceMain8402 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceMain8402.class, args);
    }
}
