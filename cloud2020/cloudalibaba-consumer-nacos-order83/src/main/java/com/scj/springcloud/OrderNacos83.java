package com.scj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-03 17:39
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderNacos83 {

    public static void main(String[] args) {
        SpringApplication.run(OrderNacos83.class, args);
    }
}
