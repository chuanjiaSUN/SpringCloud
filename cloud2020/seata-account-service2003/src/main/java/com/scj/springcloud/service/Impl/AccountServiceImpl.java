package com.scj.springcloud.service.Impl;

import com.scj.springcloud.mapper.AccountMapper;
import com.scj.springcloud.pojo.CommonRestlt;
import com.scj.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CookieValue;

import java.math.BigDecimal;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-11 20:26
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------------->>>seata-account扣减money开始");
//        int a = 1 / 0;
        accountMapper.decrease(userId, money);
        log.info("------------->>>seata-account扣减money结束");

    }


}
