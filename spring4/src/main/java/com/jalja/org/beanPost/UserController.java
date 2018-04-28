package com.jalja.org.beanPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	@Autowired
	private MyBeanPostProcessor myBeanPostProcessor;
	
	public void add(String beanName) {
		UserService userService= (UserService) myBeanPostProcessor.getBean(beanName);
		userService.add(1, 2);
	}
}
