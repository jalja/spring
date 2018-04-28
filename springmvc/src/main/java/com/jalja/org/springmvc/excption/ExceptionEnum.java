package com.jalja.org.springmvc.excption;

public enum ExceptionEnum {
	ERROR(-1,"ϵͳ�쳣"),
    SUCCESS(0,"�ɹ�");
	
	private ExceptionEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	private Integer code;
    private String msg;
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
