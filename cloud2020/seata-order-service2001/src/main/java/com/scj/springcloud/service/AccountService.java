package com.scj.springcloud.service;

import com.scj.springcloud.pojo.CommonRestlt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-10 22:30
 */
@FeignClient(value = "seata-account-service")
public interface AccountService {

    @PostMapping(value = "/account/decrease")
    CommonRestlt decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
