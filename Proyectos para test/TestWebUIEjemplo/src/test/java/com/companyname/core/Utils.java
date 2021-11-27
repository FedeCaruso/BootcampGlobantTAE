package com.companyname.core;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.Reporter;

public class Utils {

	public static void writeToLog(String log) {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("HH:mm:ss.S");
		System.out.println("["+ df.format(now) +"]"+log);
		Reporter.log("<br>"+log);
	}

	public static String loadProperty(String name) {
		InputStream s = Utils.class.getResourceAsStream("/config.properties");
		Properties props = new Properties();
		try {
			props.load(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props.getProperty(name);
	}
}
