package com.jalja.org.springmvc.excption;

public class CustomException extends  Exception {
	private Integer code;
	private String msg;


	public CustomException(ExceptionEnum exceptionEnum) {
		this.code=exceptionEnum.getCode();
		this.msg=exceptionEnum.getMsg();
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
