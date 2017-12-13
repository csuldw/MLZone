package com.mlzone.csuldw.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String DATE_FORMAT_PATTEN_TYPE1 = "YYYY-MM-dd HH:mm:ss";
	
	public static String getFormatedDate(String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
		String str = formatter.format(curDate);
		return str;
	}

	public static void main(String[] args) {
		System.out.println(getFormatedDate(DATE_FORMAT_PATTEN_TYPE1));
	}
}
