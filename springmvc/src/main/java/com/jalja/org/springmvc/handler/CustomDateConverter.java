package com.jalja.org.springmvc.handler;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.convert.converter.Converter;



public class CustomDateConverter implements Converter<String, Date>{
	private static Logger logger = LogManager.getLogger(CustomDateConverter.class);

	@Override
	public Date convert(String source) {
		logger.info("日期参数["+source+"]");
		DateTimeFormatter strToDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		TemporalAccessor dateTemporal = strToDateFormatter.parse(source);
		LocalDate localDate = LocalDate.from(dateTemporal);
		ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = localDate.atStartOfDay(zoneId);
        Date date = Date.from(zdt.toInstant());
		return date;
	}
}
