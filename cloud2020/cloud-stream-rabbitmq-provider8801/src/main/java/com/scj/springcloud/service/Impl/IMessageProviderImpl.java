package com.scj.springcloud.service.Impl;

import com.scj.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.UUID;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-02 17:43
 */
@EnableBinding(Source.class) // 定义消息的推送管道， 指定信道channel与exchange绑定
public class IMessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;//消息发送管道

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*********serial: " + serial);
        return null;
    }
}
