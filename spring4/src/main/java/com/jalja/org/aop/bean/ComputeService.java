package com.jalja.org.aop.bean;

import org.springframework.stereotype.Service;

@Service
public class ComputeService {
	public void add(int a,int b) {
		System.out.println("a+b="+(a+b));
	}
}
