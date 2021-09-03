package com.scj.springcloud.controller;

import com.scj.springcloud.pojo.Account;
import com.scj.springcloud.pojo.CommonRestlt;
import com.scj.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-11 20:24
 */
@RestController
@Slf4j
public class AccountController {


    @Autowired
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonRestlt decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money)
    {
        accountService.decrease(userId, money);
        return new CommonRestlt(200, "账户金额扣减成功");
    }

}
