package org.Eureka.Feign.Client.FeignConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;

/*
 * Feign Client的配之类
 * Feign在远程调用失败后会重试
 * */
@Configuration
public class FeignConfig {
    @Bean
    public Retryer feignRetryer(){
    	return new Retryer.Default(100, 1000, 5); //重试间隔为 100ms，最大重试时间为 1s, 重试次数为 5 次
    }
}
