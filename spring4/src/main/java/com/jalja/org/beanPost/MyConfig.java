package com.jalja.org.beanPost;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan(value="com.jalja.org.beanPost")
public class MyConfig {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext config=new AnnotationConfigApplicationContext(MyConfig.class);
		UserController uc=config.getBean(UserController.class);
		uc.add("userservice2");
		System.out.println(config.getDisplayName());
		
	}
}
