package com.jalja.org.springmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	private static Logger logger = LogManager.getLogger(HelloController.class);
	@GetMapping("getHello")
	@ResponseBody
	public String getHello(String name) {
		logger.info("name["+name+"]");
		return name;
	}
}
