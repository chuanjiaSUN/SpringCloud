package com.scj.springcloud.service;

import com.scj.springcloud.pojo.CommonRestlt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-10 22:30
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    @PostMapping(value = "/storage/decrease")
    CommonRestlt decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
