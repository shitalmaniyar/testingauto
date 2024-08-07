package com.stauto.utils;

import org.openqa.selenium.By;


public class ObjectRepository {
	public static String filePath = System.getProperty("user.dir") + "/src/main/resources/ObjectRepository.properties";

	public static String getPropertyOfRepository(String property) {
		FIleUtility util = new FIleUtility();
		property = util.readProperty(filePath, property);
		System.out.println("Propetry:"+property);
		return property;
	}

	public static By getLocator(String ele) {
		By locator = null;
		String[] element= {};
		element = getPropertyOfRepository(ele).split(":-");
		//Log.info("Element:"+element);
		String locatorType = element[0];
		String locatorValue = element[1];
//		System.out.println("Element[0]:"+element[0]);
//		System.out.println("Element[1]:"+element[1]);
		
		switch (locatorType.trim().toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "tag":
			locator = By.tagName(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallink":
			locator = By.partialLinkText(locatorValue);
			break;
		case "css":
			locator = By.cssSelector(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		}
		return locator;
	}

}
