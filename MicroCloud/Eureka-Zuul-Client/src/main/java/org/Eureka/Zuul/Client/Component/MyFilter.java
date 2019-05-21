package org.Eureka.Zuul.Client.Component;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 
 * @ClassName:  MyFilter   
 * @Description:在Zuul中实现过滤器   
 * @author: 申梦杰 
 * @date:   2019年5月20日 下午3:37:45
 * @version 1.8.0   
 * @param    
 *
 */
@Component
public class MyFilter extends ZuulFilter{
    private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MyFilter.class);
    
	@Override
	public Object run() {   //具体的过滤逻辑
		RequestContext context =RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		Object accessToken = request.getParameter("token");
		if(accessToken==null){
			log.warn("token is empty");
		    context.setSendZuulResponse(false);
		    context.setResponseStatusCode(401);
		    try {
				context.getResponse().getWriter().write("token is empty");
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		log.info("ok");
		return null;
	}

	@Override
	public boolean shouldFilter() {   //如果为true执行run方法，如果为false不执行run方法
		return true;
	}

	@Override
	public int filterOrder() {   //过滤顺序，值越小越早执行过滤功能
		return 0;
	}

	@Override
	public String filterType() {   //过滤的类型，即在哪个阶段过滤，有四种类型"pre","post","routing","error"
		return "pre";
	}

}
