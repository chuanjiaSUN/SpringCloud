package com.scj.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-20 20:53
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //@LoadBalanced //开启RestTemplate负载均衡
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

}
