package com.scj.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-11 19:47
 */
@Mapper
public interface StorageMapper {

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
