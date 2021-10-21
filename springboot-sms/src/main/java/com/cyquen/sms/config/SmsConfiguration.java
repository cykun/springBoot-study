package com.cyquen.sms.config;

import com.aliyun.teaopenapi.models.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsConfiguration {

    @Value("${aliyun.accessKeyId}")
    public String accessKeyId;

    @Value("${aliyun.accessKeySecret}")
    public String accessKeySecret;

    @Bean
    public com.aliyun.dysmsapi20170525.Client createClient() throws Exception {
        Config config = new Config()
                .setAccessKeyId(accessKeyId)
                .setAccessKeySecret(accessKeySecret);
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }
}
