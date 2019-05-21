package org.Eureka.Ribbon.Client.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * 注意uri上不需要硬编码，只需要天上eureka-Client的服务名即可    
 *
 */
@Service
public class RibbonService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod="hiError")
    public String hi(String name) {
        return restTemplate.getForObject("http://service-hi/hi?name="+name,String.class);//String.class是返回的类型
    }
    public String hiError(String name){
    	return "hi,"+name+",sorry,error!";
    }
}
