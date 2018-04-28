package com.jalja.org.springmvc.handler;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RequestFilter implements Filter {
	private static Logger logger = LogManager.getLogger(RequestFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.info("init");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("doFilter");
		
		chain.doFilter(request, response);
	}
	@Override
	public void destroy() {
		logger.info("destroy");
	}

}
