package com.scj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-04 17:40
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceMain8401 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceMain8401.class, args);
    }
}
