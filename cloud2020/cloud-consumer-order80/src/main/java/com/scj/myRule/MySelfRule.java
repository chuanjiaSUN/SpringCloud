package com.scj.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-26 21:09
 */
@Configuration
public class MySelfRule {

        //将负载规则更改为随机
        @Bean
        public IRule myRule()
        {
            return new RandomRule();
        }
}
