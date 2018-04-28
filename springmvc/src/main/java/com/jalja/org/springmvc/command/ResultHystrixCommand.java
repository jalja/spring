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
	            //�����̳߳�������ԣ����д�С���߳���  
	            .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withMaxQueueSize(5).withCoreSize(5))  
	            //����������ز��������г�ʱʱ��  
	            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(1000)));  
		this.url=url;
	}
	@Override
	protected String run() throws Exception {
		return HttpRequestUtil.getResult(null,url+"",null);
	}
	@Override
	protected String getFallback() {
		logger.info("����getFallback ��¼��־");
		WeatherVO vo=new WeatherVO("1","2","3","4","5",5.0,"5","6","7","8");
		return  JSONObject.toJSONString(vo);
	}
	
}
