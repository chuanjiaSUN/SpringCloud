package com.scj.springcloud.controller;

import com.scj.springcloud.entites.CommonResult;
import com.scj.springcloud.entites.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-07 15:13
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;


    //模拟DAO层
    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L, new Payment(1L, "25154502123as1fafasfassa541"));
        hashMap.put(2L, new Payment(2L, "25154502ffs123as1fafasfassa542"));
        hashMap.put(3L, new Payment(3L, "25154253assa1fafasfassa543"));
        hashMap.put(4L, new Payment(4L, "2515451ass2123as1fafasfassa544"));
    }

    @GetMapping(value = "/paymentSql/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id)
    {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> commonResult = new CommonResult<>(200, "from mysql, serverPort: " + serverPort, payment);
        return commonResult;
    }
}
