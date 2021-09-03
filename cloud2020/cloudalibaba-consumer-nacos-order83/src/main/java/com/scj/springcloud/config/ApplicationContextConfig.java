package com.scj.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-03 17:44
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced // 加这个，可通过微服务名进行负载均衡调用
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
