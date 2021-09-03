package com.scj.springcloud.service;

import com.scj.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-20 18:22
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
