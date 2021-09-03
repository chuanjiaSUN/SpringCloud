package com.scj.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-29 20:34
 */
@Configuration
public class GateWayConfig {

    //路由配置方式2
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder)
    {
        //http://news.baidu.com/guonei
        return builder.routes()
                .route("pathRouteScj1", r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .route("pathRouteScj2", r -> r.path("/guoji").uri("http://news.baidu.com/guoji"))
                .build();
    }
}
