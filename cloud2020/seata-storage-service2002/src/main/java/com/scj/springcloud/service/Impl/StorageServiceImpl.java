package com.scj.springcloud.service.Impl;

import com.scj.springcloud.mapper.StorageMapper;
import com.scj.springcloud.service.StorageService;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-11 19:51
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {


    @Autowired
    private StorageMapper storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------------->>> storage-service扣减库存开始");
        storageMapper.decrease(productId, count);
        log.info("------------->>> storage-service扣减库存结束");
    }
}
