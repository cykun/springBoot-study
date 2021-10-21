package com.cyquen.sms.controller;

import com.aliyun.dysmsapi20170525.*;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    public Client smsClient;

    @GetMapping("/code")
    public String sendCode(@RequestParam String phone) throws Exception {
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setPhoneNumbers(phone)
                .setSignName("vslab")
                .setTemplateCode("SMS_167973886")
                .setTemplateParam("{\"code\":\"1111\"}");
        smsClient.sendSms(sendSmsRequest);
        return "send success";
    }
}
