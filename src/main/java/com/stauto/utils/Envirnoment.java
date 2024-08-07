package com.stauto.utils;

public class Envirnoment {
	public static String filePath = System.getProperty("user.dir") + "/src/main/resources/Envirnoment.properties";

	public static String getEnvProperty(String property) {
		FIleUtility util = new FIleUtility();
		property = util.readProperty(filePath, property);
		return property;
	}

	public static String getBrowserName() {
		return getEnvProperty("browser");
	}

	public static String getURL() {
		return getEnvProperty("url");
	}

	
}
