package com.jalja.org.springmvc.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalja.org.springmvc.model.vo.WeatherVO;
import com.jalja.org.springmvc.service.WeatherService;

@RestController
public class HystrixController {
	private  Logger logger=LogManager.getLogger(HystrixController.class);
	@Autowired
	private WeatherService weatherService;
	 @GetMapping(value = "getHystrix")
     public WeatherVO getHystrix() throws Exception{
        return weatherService.getWeatherVO("±±¾©");
     }
}
