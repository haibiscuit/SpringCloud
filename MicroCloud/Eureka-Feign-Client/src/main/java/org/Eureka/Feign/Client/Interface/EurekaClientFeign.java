package org.Eureka.Feign.Client.Interface;

import org.Eureka.Feign.Client.FeignConfig.FeignConfig;
import org.Eureka.Feign.Client.Impl.HiHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * 1.@FeignClient(value="service-hi",configuration=FeignConfig.class)
 *   value为远程调用其他服务的服务名,FeignConfig.class为Feign Client的配之类
 * 2.sayHiFromClientEureka方法
 *     该方法通过Feign来调用Feign Client服务的"/hi"的Api接口
 */
@FeignClient(value="service-hi",configuration=FeignConfig.class,fallback=HiHystrix.class)
public interface EurekaClientFeign {
    @GetMapping(value="/hi")
    String sayHiFromClientEureka(@RequestParam(value="name") String name);
}
