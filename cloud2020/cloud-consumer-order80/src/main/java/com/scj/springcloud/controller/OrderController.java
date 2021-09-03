package com.scj.springcloud.controller;

import com.scj.springcloud.entites.CommonResult;
import com.scj.springcloud.entites.Payment;
import com.scj.springcloud.lb.LoadBalancer;
import javafx.scene.chart.ValueAxis;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-05-20 20:51
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";  //单机版

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; //集群版, 以微服务名称去调用微服务

    @Autowired
    private RestTemplate restTemplate;//远程调用服务端的东西， 类似与httpClient

    @Autowired
    private LoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;
    //测试 Ribbon的rest调用的两个post方法
    // getForObject 返回json
    // postForEntity 返回responseEntity对象
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment)
    {
//        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);//post 3个参数
        return restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class).getBody();
    }


    //测试 Ribbon的rest调用的get两个方法
    // getForObject 返回json
    // getForEntity 返回responseEntity对象
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id)
    {
//        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);//get 两个参数

        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful())
        {
            return forEntity.getBody();
        }else {
            return new CommonResult<>(444, "操作失败");
        }
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null | instances.size() <= 0)
        {
            return null;
        }
        ServiceInstance myServiceInstance = loadBalancer.instances(instances);//自己写的负载均衡算法
        URI uri = myServiceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

    //===================> zipkin + sleuth
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin/", String.class);
        return result;
    }

}
