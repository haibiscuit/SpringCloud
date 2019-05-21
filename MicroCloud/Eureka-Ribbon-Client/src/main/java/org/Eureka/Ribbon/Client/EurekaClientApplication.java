package org.Eureka.Ribbon.Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 
 * @ClassName:  EurekaClientApplication   
 * @Description:
 * 使用Ribbon和Resttemplate搭建消费服务,并且RestTemplate与Ribbon相结合开启负载均衡
 * 
 * 
 * 另外:该服务的大体流程是,客户端先怼到该服务下的Controller，
 * 然后resttemplate通过Ribbon负载均衡查询Eureka-Server服务器,
 * 接着,调用Service下的方法,负载均衡到后台的具体服务
 * 也就是该服务为一个负载均衡的服务
 * https://www.cnblogs.com/linkworld/p/9191161.html(推荐学习网址)
 *
 */
/**
 * 这里讲一下Hystrix的工作机制:
 * 当某个服务的API接口的失败次数在一定时间内小于设定的阈值时，熔断器处于关闭状态，该API接口正常提供服务，
 * 反之,打开熔断器，请求该Api执行快速失败的逻辑(即fallback回退的逻辑),不执行业务逻辑，请求的线程不会处于阻塞状态
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient    //如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class EurekaClientApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(EurekaClientApplication.class, args);
    }
}
