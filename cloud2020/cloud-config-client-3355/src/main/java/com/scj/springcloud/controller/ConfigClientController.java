package com.scj.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-30 16:47
 */
@RestController
@Slf4j
@RefreshScope // 可以实现动态配置更新
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

//    @Value("${server.port}")
//    private String serverPort;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return "serverPort: "+" \t\n\n configInfo: "+configInfo;
    }

}
