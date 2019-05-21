package org.Eureka.Feign.Client.Service;

import org.Eureka.Feign.Client.Interface.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 1.注入EurekaClientFeign的Bean,通过EurekaClientFeign调用sayHiFromClientEureka()方法
 */
@Service
public class HiService {
    @Autowired
    EurekaClientFeign eurekaClientFeign;
    public String sayHi(String name){
    	return eurekaClientFeign.sayHiFromClientEureka(name);
    }
}
