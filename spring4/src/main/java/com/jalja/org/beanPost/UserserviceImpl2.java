package com.jalja.org.beanPost;

import org.springframework.stereotype.Service;

@Service(value="userservice2")
public class UserserviceImpl2 implements UserService {
	@Override
	public void add(int a, int b) {
		System.out.println("UserserviceImpl2:" +(a+b));
	}
}
