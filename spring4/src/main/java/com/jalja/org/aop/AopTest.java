package com.jalja.org.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jalja.org.aop.bean.ComputeService;




public class AopTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext config=new AnnotationConfigApplicationContext(AopConfig.class);
		ComputeService cService=config.getBean(ComputeService.class);
		cService.add(1, 2);
	}
}
