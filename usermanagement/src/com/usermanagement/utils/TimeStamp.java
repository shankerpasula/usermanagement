package com.usermanagement.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp {
	
	public String getTimeStamp()
	{
		String timeStamp = new SimpleDateFormat("dd.hh.mm").format(new Date()).replace(".", "");
		return timeStamp;
	}

}
