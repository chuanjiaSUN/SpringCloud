package com.scj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-20 17:53
 */

@SpringBootApplication
@EnableEurekaClient // 表示自己是提供服务的Eureka Client
@EnableDiscoveryClient // 表示服务发现
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class, args);
    }
}
