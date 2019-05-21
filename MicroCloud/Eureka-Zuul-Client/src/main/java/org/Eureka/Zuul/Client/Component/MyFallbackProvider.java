package org.Eureka.Zuul.Client.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
/**
 * 
 * @ClassName:  MyFallbackProvider   
 * @Description:Zuul中实现熔断器   
 * @author: 申梦杰 
 * @date:   2019年5月20日 下午3:36:58
 * @version 1.8.0   
 * @param    
 *
 */
@Component
public class MyFallbackProvider implements ZuulFallbackProvider{

	@Override
	public ClientHttpResponse fallbackResponse() {
		
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);   //响应类型
				return headers;
			}
			
			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("oooops!error,I'AmazonInfo the fallback!".getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
				return "OK";
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				return 200;
			}
			
			@Override
			public void close() {
				
			}
		};
	}

	@Override
	public String getRoute() {    //指定哪些服务需要加熔断服务的
		return "*";
	}

}
