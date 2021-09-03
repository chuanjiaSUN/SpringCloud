package com.scj.springcloud.controller;

import com.scj.springcloud.pojo.CommonRestlt;
import com.scj.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-11 19:40
 */
@RestController
@Slf4j
public class StorageController {

    @Autowired
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonRestlt decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count)
    {
        storageService.decrease(productId, count);
        return new CommonRestlt(200, "扣减库存成功");
    }

}
