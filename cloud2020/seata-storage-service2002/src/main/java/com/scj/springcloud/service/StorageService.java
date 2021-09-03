package com.scj.springcloud.service;

import com.scj.springcloud.pojo.CommonRestlt;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-11 19:40
 */
public interface StorageService {

    void decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
