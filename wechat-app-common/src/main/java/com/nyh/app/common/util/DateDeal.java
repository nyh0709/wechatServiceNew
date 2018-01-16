package com.nyh.app.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDeal {
	
	public static String currentDateTime() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date = simpleDateFormat.format(date);
		return create_date;
	}

}
