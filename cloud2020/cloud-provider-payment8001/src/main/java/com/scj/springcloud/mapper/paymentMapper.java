package com.scj.springcloud.mapper;

import com.scj.springcloud.entites.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-20 18:10
 */
@Mapper
public interface paymentMapper {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
