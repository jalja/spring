package com.jalja.org.springmvc.excption;

public class ExceptionResult {
	private Integer code;
	private String msg;
	
	public ExceptionResult(CustomException customException) {
		super();
		this.code = customException.getCode();
		this.msg = customException.getMsg();
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
