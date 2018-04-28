package com.jalja.org.beanPost;

import org.springframework.stereotype.Service;

@Service(value="userservice1")
public class UserserviceImpl1 implements UserService {
	@Override
	public void add(int a, int b) {
		System.out.println("UserserviceImpl1:" +(a+b));
	}

}
