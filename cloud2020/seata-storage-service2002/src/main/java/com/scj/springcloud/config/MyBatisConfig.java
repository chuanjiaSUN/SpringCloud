package com.scj.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-11 15:23
 */
@Configuration
@MapperScan({"com.scj.springcloud.mapper"})
public class MyBatisConfig {
}
