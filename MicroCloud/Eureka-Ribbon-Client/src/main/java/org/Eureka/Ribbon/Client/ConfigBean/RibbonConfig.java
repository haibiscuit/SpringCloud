package org.Eureka.Ribbon.Client.ConfigBean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
 * 在Ioc容器上注入一个restTemplate的bean,
 * 在这个bean上加上@LoadBalanced注解，此时RestTemplate就结合了Ribbon开启了负载均衡功能
 * 
 * */
@Configuration
public class RibbonConfig {
	@Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
