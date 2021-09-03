package com.scj.springcloud.controller;

import com.scj.springcloud.entites.CommonResult;
import com.scj.springcloud.entites.Payment;
import com.scj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-20 20:11
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        int result = paymentService.create(payment);
        log.info("**********插入结果: " + result);

        if (result > 0) return new CommonResult(200, "插入数据库成功,serverPort: "+serverPort, result);
        else return new CommonResult(444,"插入数据库失败", null);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("***********查询结果: "+paymentById);
        if (paymentById != null)
        {
            return new CommonResult(200, "查询成功,serverPort: "+serverPort, paymentById);
        }else {
            return new CommonResult(444, "查询失败 ,id :" + id, null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLb()
    {
        return serverPort;
    }
}
