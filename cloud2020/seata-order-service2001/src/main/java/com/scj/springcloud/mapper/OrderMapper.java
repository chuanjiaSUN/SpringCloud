package com.scj.springcloud.mapper;

import com.scj.springcloud.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-10 22:05
 */
@Mapper
public interface OrderMapper {

    //1.新建订单
    void create(Order order);

    //2.修改订单状态，从0改为1
    void updata(@Param("userId") Long userId, @Param("status") Integer status);
}
