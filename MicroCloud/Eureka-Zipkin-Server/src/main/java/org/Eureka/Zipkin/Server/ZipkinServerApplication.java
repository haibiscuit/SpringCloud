package org.Eureka.Zipkin.Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import zipkin.server.EnableZipkinServer;
/**
 * 
 * @ClassName:  ZipkinServerApplication   
 * @Description:服务链路追踪   
 * @author: 申梦杰 
 * @date:   2019年5月21日 下午12:03:08
 * @version 1.8.0   
 * @param    
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class ZipkinServerApplication {
    public static void main(String args[]){
    	SpringApplication.run(ZipkinServerApplication.class, args);
    }
}
