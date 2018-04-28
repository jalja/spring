package com.jalja.org.springmvc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jalja.org.springmvc.model.HelloWord;

@Configuration
public class Test {
	@Bean(value="helloWord")
	public HelloWord getHelloWord() {
		return new HelloWord();
	}
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				Test.class);
		HelloWord hello=(HelloWord)context.getBean("helloWord");
		hello.setMessage("ÖÐ¹ú");
		hello.getMessage();
	}
}
