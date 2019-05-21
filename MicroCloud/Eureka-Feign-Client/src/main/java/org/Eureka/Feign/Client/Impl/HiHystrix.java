package org.Eureka.Feign.Client.Impl;

import org.Eureka.Feign.Client.Interface.EurekaClientFeign;
import org.springframework.stereotype.Component;

@Component
public class HiHystrix implements EurekaClientFeign{

	@Override
	public String sayHiFromClientEureka(String name) {
		return "hi,"+name+",sorry,error!";
	}
	

}
