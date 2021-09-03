package com.scj.springcloud.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-11 20:25
 */
public interface AccountService {

    void decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money);
}
