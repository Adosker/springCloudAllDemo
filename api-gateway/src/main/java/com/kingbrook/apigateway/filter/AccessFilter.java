package com.kingbrook.apigateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AccessFilter extends ZuulFilter {
	
	private static Logger log = LoggerFactory.getLogger(AccessFilter.class);
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		Object accessToken = request.getParameter("acceessToken");
		if(accessToken == null) {
			log.warn("access token is empty");
			//不对其路由
			ctx.setSendZuulResponse(false);
			ctx.getResponse().setContentType("text/html;charset=UTF-8");
			ctx.setResponseBody("没有权限");
			ctx.setResponseStatusCode(401);
			return null;
		}
		log.info("access token ok");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
