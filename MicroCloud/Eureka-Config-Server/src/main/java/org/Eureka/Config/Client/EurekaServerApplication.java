package org.Eureka.Config.Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 
 * @ClassName:  EurekaServerApplication   
 * @Description: 配置中心   
 * @author: 申梦杰 
 * @date:   2019年5月20日 下午6:14:49
 * @version 1.8.0   
 * @param    
 *
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class EurekaServerApplication {
	
    public static void main(String args[]){
    	SpringApplication.run(EurekaServerApplication.class, args);
    }
}
