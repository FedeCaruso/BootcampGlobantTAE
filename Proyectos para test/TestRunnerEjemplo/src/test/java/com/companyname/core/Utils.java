package com.companyname.core;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.Response;
import org.testng.Reporter;

public class Utils {

	/**
	 * Writes a string into a log and prints it by console
	 * @param log
	 */
	public static void writeToLog(String log) {
		Date now = new Date();
		DateFormat df = new SimpleDateFormat("HH:mm:ss.S");
		System.out.println("["+ df.format(now) +"]"+log);
		Reporter.log("<br>"+log);
	}

	/**
	 * Loads properties from config file
	 * @param name
	 * @return
	 */
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

	/**
	 * Simulates network conditions
	 * @param driver
	 * @param download_throughput
	 * @param upload_throughput
	 * @throws IOException
	 */
	public static void networkThrotting(WebDriver driver, int download_throughput, int upload_throughput) throws IOException {
		Map map = new HashMap();
		map.put("offline", false);
		map.put("latency", 5);
		map.put("download_throughput", download_throughput);
		map.put("upload_throughput", upload_throughput);


		CommandExecutor executor = ((ChromeDriver)driver).getCommandExecutor();
		Response response = executor.execute(
				new Command(((ChromeDriver)driver).getSessionId(),    "setNetworkConditions", ImmutableMap.of("network_conditions", ImmutableMap.copyOf(map)))
		);
	}
}
