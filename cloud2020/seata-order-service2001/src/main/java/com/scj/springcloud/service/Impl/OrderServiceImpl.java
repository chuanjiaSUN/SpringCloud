package com.scj.springcloud.service.Impl;

import com.scj.springcloud.mapper.OrderMapper;
import com.scj.springcloud.pojo.Order;
import com.scj.springcloud.service.AccountService;
import com.scj.springcloud.service.OrderService;
import com.scj.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-10 22:31
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;


    @Override
//    @GlobalTransactional(name = "my_test_tx_group", rollbackFor = Exception.class)
//    @GlobalTransactional
    public void create(Order order) {


        log.info("---------->>>开始新建订单");
        orderMapper.create(order);

        log.info("---------->>>订单微服务开始调用库存， 做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("---------->>>订单微服务开始调用库存， 做扣减end");
        //...
        log.info("---------->>>账户微服务开始做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("---------->>>账户微服务开始做扣减, end");

        //修改订单状态, 从0 到 1， 1代表完成
        log.info("-------->>>修改订单状态开始");
        orderMapper.updata(order.getUserId(), 0);
        log.info("-------->>>修改订单状态, end");

        log.info("-------->>>下订单end,O(∩_∩)O");

    }
}
