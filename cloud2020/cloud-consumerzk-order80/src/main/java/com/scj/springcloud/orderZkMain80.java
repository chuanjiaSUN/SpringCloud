package com.scj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-25 17:07
 */
@SpringBootApplication
@EnableDiscoveryClient
public class orderZkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(orderZkMain80.class, args);
    }
}
