package com.scj.springcloud.service.impl;

import com.scj.springcloud.mapper.paymentMapper;
import com.scj.springcloud.entites.Payment;
import com.scj.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-20 18:23
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private paymentMapper paymentMapper;

    public int create(Payment payment)
    {
        return paymentMapper.create(payment);
    }

    public Payment getPaymentById(@Param("id") Long id)
    {
        return paymentMapper.getPaymentById(id);
    }
}
