package com.scj.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-11 20:17
 */
@Mapper
public interface AccountMapper {

    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
