package com.jalja.org.beanPost;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
@Component
public class MyBeanPostProcessor implements BeanPostProcessor{
	public static Map<String,Object> map=new ConcurrentHashMap<String,Object>();
	@Override
	public Object postProcessAfterInitialization(Object bean, String arg) throws BeansException {
		System.out.println("=======postProcessAfterInitialization=====["+bean+"]==["+arg+"]===");
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String arg) throws BeansException {
		System.out.println("=======postProcessBeforeInitialization=====["+bean+"]=====");
		if(bean instanceof UserService) {
			map.put(arg, bean);
			System.out.println(map.size());
		}
		return bean;
	}
	public Object getBean(String beanName) {
		return map.get(beanName);
	}
}
