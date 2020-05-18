package com.t2s.staying.home.T2S.utils;

import java.time.ZoneId;
import java.util.TimeZone;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class DateUtils {

	private static final String DEFAULT_DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";

	public static String getTimezoneStringDate(Long dateMillis, String dateFormat) {
		DateTime dt = new DateTime(dateMillis);
		dt.toDateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone(ZoneId.systemDefault())));

		return dt.toString(dateFormat != null ? dateFormat : DEFAULT_DATE_FORMAT);
	}
}
