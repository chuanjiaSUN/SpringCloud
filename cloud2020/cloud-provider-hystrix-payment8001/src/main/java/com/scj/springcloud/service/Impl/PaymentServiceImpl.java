package com.scj.springcloud.service.Impl;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.scj.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-27 21:20
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    //正常访问OK
    public String paymentInfo(Integer id)
    {
        return "线程池： " + Thread.currentThread().getName() + "  paymentInfo, id:   " + id + "\t" + "~~~哈哈哈";
    }

    //==============服务降级

    //模拟出错
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",
            commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    }) //引入服务降级  ,规定这个线程超时时间 为  3s
    public String paymentInfo_Timeout(Integer id)
    {
        int timeNumber = 5;
//        int age = 10 / 0;  //模拟服务侧宕机 ， 程序出错
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池：   " + Thread.currentThread().getName() + "      paymentInfo, id   " + id + "\t" + " !!!" + " 耗时 "+timeNumber+ " 秒钟" ;
    }

    public String paymentInfo_TimeoutHandler(Integer id)
    {
        return "线程池：    " + Thread.currentThread().getName() + "  8001系统繁忙，请稍后再试  id: " + id + "\t" + "/(ㄒoㄒ)/~~";
    }

    //==================服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",
    commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")//失败率达到多少跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if (id < 0)
        {
            throw new RuntimeException("******id 不能为负数");
        }
//        String serialName = UUID.randomUUID().toString();
        String serialName = IdUtil.simpleUUID(); //等价

        return Thread.currentThread().getName() + "\t" +"调用成功，流水号： " + serialName;
    }
    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id)
    {
        return "id 不能为负数， 请稍后重试， /(ㄒoㄒ)/~~,  id: " + id ;
    }


}
