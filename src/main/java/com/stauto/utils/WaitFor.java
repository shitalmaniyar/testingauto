package com.stauto.utils;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.stauto.UIKeywords.UIKeywords;

public class WaitFor  {
	public static FluentWait<WebDriver> wait;
	static {
		wait=new FluentWait<WebDriver>(UIKeywords.driver);
		wait.withTimeout(Duration.ofSeconds(100));
		wait.pollingEvery(Duration.ofMillis(50));
		wait.ignoring(NoSuchElementException.class,ElementClickInterceptedException.class);
	}

	public static boolean invisibilityOfElement(By locator) {
		WebElement ele = UIKeywords.findElement(locator);
		return wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public static void stalenessOfElement(By locator) {
		wait.until(ExpectedConditions.stalenessOf(UIKeywords.findElement(locator)));
	}

	public static void waitElementTobeVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOf(UIKeywords.driver.findElement(locator)));
	}
	
	public static void waitUntilPageLoad(WebElement element){
	
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public static void waitElementToBeClickable(By ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public static void waitElementToBeClickable(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void waitTillElementTOBeInteractable(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void waitStaleElementExceptionhandle(List<WebElement> ele) {
		//	wait.until(ExpectedConditions.stalenessOf((WebElement) ele));
		UIKeywords.driver.navigate().refresh();
	}

}
