package com.jalja.org.springmvc.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.jalja.org.springmvc.model.vo.WeatherVO;
import com.jalja.org.springmvc.utils.HttpRequestUtil;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolProperties;

public class ResultHystrixCommand extends HystrixCommand<String>{
	private  Logger logger=LogManager.getLogger(ResultHystrixCommand.class);
	private String url;
	public ResultHystrixCommand(String url,String group) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(group))  
	            //配置线程池相关属性，队列大小和线程数  
	            .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withMaxQueueSize(5).withCoreSize(5))  
	            //配置运行相关参数如运行超时时间  
	            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(1000)));  
		this.url=url;
	}
	@Override
	protected String run() throws Exception {
		return HttpRequestUtil.getResult(null,url+"",null);
	}
	@Override
	protected String getFallback() {
		logger.info("进入getFallback 记录日志");
		WeatherVO vo=new WeatherVO("1","2","3","4","5",5.0,"5","6","7","8");
		return  JSONObject.toJSONString(vo);
	}
	
}
