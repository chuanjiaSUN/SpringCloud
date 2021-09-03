package com.scj.springcloud.controller;

import com.scj.springcloud.pojo.CommonRestlt;
import com.scj.springcloud.pojo.Order;
import com.scj.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-11 15:21
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonRestlt create(Order order)
    {
        orderService.create(order);
        return new CommonRestlt(200, "订单创建成功");
    }

}
