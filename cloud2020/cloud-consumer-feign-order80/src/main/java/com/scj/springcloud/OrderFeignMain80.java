package com.scj.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-26 22:29
 */
@SpringBootApplication
@EnableFeignClients //代表使用OpenFeign客户端进行远程调用
public class OrderFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
