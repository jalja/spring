package com.jalja.org.springmvc.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jalja.org.springmvc.utils.HttpRequestUtil;


public class RequestHandlerInterceptor implements HandlerInterceptor  {
	
	private static Logger logger = LogManager.getLogger(RequestHandlerInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("«Î«ÛΩ¯»Î");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("postHandle");
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;  
			logger.info("IP="+HttpRequestUtil.getIpAddress(request)+" url="+request.getRequestURL()+" method="+handlerMethod.getMethod().getName()+"");
		}
		//HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("afterCompletion");
		//HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
