package com.valoya.login.login.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {
	public static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static final Date getFormattedCurrentDate() {
		try {
			return SDF.parse(SDF.format(new Date()));
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static final String getFormattedCurrentDateString() {
		return SDF.format(new Date());
	}
}
