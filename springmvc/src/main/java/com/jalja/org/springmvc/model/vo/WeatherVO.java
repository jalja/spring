package com.jalja.org.springmvc.model.vo;

import java.io.Serializable;

public class WeatherVO implements Serializable{
	private String date;
	private String sunrise;
	private String high;
	private String low;
	private String sunset;
	private Double aqi;
	private String fx;
	private String fl;
	private String type;
	private String notice;
	
	public WeatherVO(String date, String sunrise, String high, String low, String sunset, Double aqi, String fx,
			String fl, String type, String notice) {
		super();
		this.date = date;
		this.sunrise = sunrise;
		this.high = high;
		this.low = low;
		this.sunset = sunset;
		this.aqi = aqi;
		this.fx = fx;
		this.fl = fl;
		this.type = type;
		this.notice = notice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSunrise() {
		return sunrise;
	}
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getSunset() {
		return sunset;
	}
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}
	public Double getAqi() {
		return aqi;
	}
	public void setAqi(Double aqi) {
		this.aqi = aqi;
	}
	public String getFx() {
		return fx;
	}
	public void setFx(String fx) {
		this.fx = fx;
	}
	public String getFl() {
		return fl;
	}
	public void setFl(String fl) {
		this.fl = fl;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
}
