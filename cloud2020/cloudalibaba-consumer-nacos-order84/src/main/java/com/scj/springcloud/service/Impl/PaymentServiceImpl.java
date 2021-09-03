package com.scj.springcloud.service.Impl;

import com.scj.springcloud.entites.CommonResult;
import com.scj.springcloud.entites.Payment;
import com.scj.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-07 19:56
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSql(Long id) {
        return new CommonResult<>(444, "服务降级返回--->> PaymentServiceImpl", new Payment(id, "errorSerial"));
    }
}
