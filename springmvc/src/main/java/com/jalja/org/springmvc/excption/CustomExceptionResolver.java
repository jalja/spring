package com.jalja.org.springmvc.excption;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;


public class CustomExceptionResolver implements HandlerExceptionResolver{
	private static Logger logger = LogManager.getLogger(CustomExceptionResolver.class);
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
	    response.setStatus(HttpStatus.OK.value()); //…Ë÷√◊¥Ã¨¬Î  
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //…Ë÷√ContentType  
        response.setCharacterEncoding("UTF-8"); //±‹√‚¬“¬Î  
	    response.setHeader("Cache-Control", "no-cache, must-revalidate");  
	    CustomException ce=null;
	    try {
	    	 logger.info("“Ï≥£["+ex+"]");
	    	 ex.printStackTrace();
	    	 if(ex!=null && ex instanceof CustomException) {
	    		  ce=(CustomException)ex;
	    	 }else {
	    		  ce=new CustomException(ExceptionEnum.ERROR);
	    	 }
	    	 response.getWriter().write(JSONObject.toJSONString(new ExceptionResult(ce)));
	     }catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView();
	}
}
