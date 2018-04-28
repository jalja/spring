package com.jalja.org.springmvc.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.jalja.org.springmvc.command.ResultHystrixCommand;
import com.jalja.org.springmvc.model.vo.WeatherVO;

@Service
public class WeatherService {
	private  Logger logger=LogManager.getLogger(WeatherService.class);
	public WeatherVO getWeatherVO(String cityName) {
		String apiUrl = String.format("https://www.sojson.com/open/api/weather/json.shtml?city=%s",cityName);
		String result=new ResultHystrixCommand(apiUrl,"WeatherGroup").execute();
		logger.info("result["+result+"]");
		JSONObject obj=JSONObject.parseObject(result);
		JSONObject data= obj.getJSONObject("data").getJSONObject("yesterday");
		WeatherVO vo=JSONObject.parseObject(data.toJSONString(),WeatherVO.class);
		return vo;
	}
}
