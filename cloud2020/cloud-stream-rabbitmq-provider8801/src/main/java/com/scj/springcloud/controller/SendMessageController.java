package com.scj.springcloud.controller;

import com.scj.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunchuanjia
 * @Description
 * @create 2021-06-02 17:49
 */
@RestController
@Slf4j
public class SendMessageController {

    @Autowired
    private IMessageProvider messageProvider;


    @GetMapping("/sendMessage")
    public String sendMessage()
    {
        return messageProvider.send();
    }
}
