package com.scj.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.scj.springcloud.service.PaymentFeignHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-27 21:51
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallBackMethod") //定义引用全局FallBack
public class OrderFeignHystrixController {

        @Autowired
        private PaymentFeignHystrixService paymentFeignHystrixService;

        @GetMapping("/consumer/payment/hystrix/ok/{id}")
        public String FeignHystrixOk(@PathVariable("id") Integer id)
        {
            return paymentFeignHystrixService.paymentInfo_ok(id);
        }

        @GetMapping("/consumer/payment/hystrix/timeout/{id}")
        @HystrixCommand // 没配置说明用统一的服务降级
//        @HystrixCommand(fallbackMethod = "paymentTimeoutFallBackHandler",
//        commandProperties = {
//                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//        }) // 开启服务降级， 默认最多等待 1.5s， 超过即客户端服务降级
        public String FeignHystrixTimeout(@PathVariable("id") Integer id)
        {
//                int age = 10 / 0; // 模拟程序出错，服务降级
            return paymentFeignHystrixService.paymentInfoTimeout(id);
        }

        public String paymentTimeoutFallBackHandler(@PathVariable("id") Integer id)
        {
                return "我是消费者80， 对方支付系统繁忙，请10秒钟后再试或者自己运行出错检查以下，/(ㄒoㄒ)/~~";
        }

        //全局FallBack
        public String paymentGlobalFallBackMethod()
        {
                return "Global异常处理信息， 请稍后再试， /(ㄒoㄒ)/~~";
        }
}
