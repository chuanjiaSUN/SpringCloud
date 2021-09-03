package com.scj.springcloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.scj.springcloud.entites.CommonResult;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-04 22:07
 */
public class CustomerBlockHandler {

    public static CommonResult handlerExcetion1(BlockException exception)
    {
        return new CommonResult(4444,"按客户自定义的，global handleException----1");
    }

    public static CommonResult handlerExcetion2(BlockException exception)
    {
        return new CommonResult(4444,"按客户自定义的，global handleException----2");
    }
}
