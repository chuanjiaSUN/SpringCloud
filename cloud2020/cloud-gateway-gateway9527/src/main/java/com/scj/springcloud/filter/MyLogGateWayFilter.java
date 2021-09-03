package com.scj.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-29 21:24
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*********come in MyLogGateWayFilter" + new Date());
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null)
        {
            log.info("****用户名非法, /(ㄒoㄒ)/~~****");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return chain.filter(exchange);
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;//值越小，优先级越高
    }
}
