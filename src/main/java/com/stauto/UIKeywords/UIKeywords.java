package com.stauto.UIKeywords;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.stauto.exception.InvalidBrowserNameException;
import com.stauto.utils.Envirnoment;
import com.stauto.utils.ObjectRepository;
import com.stauto.utils.WaitFor;

public class UIKeywords {
	
	public static RemoteWebDriver driver;
	static ChromeOptions options = new ChromeOptions();
	public static Logger log;
	 {
		log=LogManager.getLogger(this.getClass());
	}
	public static void openBrowse(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new InvalidBrowserNameException(browserName);
		}

	}

	public static void launchAppURL(String env) {
		openBrowse(Envirnoment.getBrowserName());
		maximizeBrowser();
		driver.get(Envirnoment.getURL());
	}

	private static void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public static void clickOnElement(WebElement element) {
		element.click();
	}

	public static WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public static void clickOnElement(By locator) {
		WaitFor.waitElementToBeClickable(locator);
		driver.findElement(locator).click();
	}

	public static void sendKeysInText(By locator, String text) {
		driver.findElement(locator).sendKeys(text, Keys.ENTER);
	}

	public static void sendKeysInTextNotEnter(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}

	public static void getwindowHandle() {
		driver.getWindowHandle();
	}

	public static List<WebElement> getElements(By locator) {
		List<WebElement> elements = null;
		elements = driver.findElements(locator);
		return elements;
	}

	public static void actionsMoveToElement(WebElement ele) {
		Actions actions = new Actions(driver);
		actions.moveToElement(ele).perform();
	}

	public static void actionsMoveToAxis() {
		Actions actions = new Actions(driver);
		actions.moveByOffset(400, 50);
	}

	public static void actionsMoveToOffset(int x, int y) {
		Actions actions = new Actions(driver);
		actions.moveByOffset(x, y).perform();
	}

	public static void pageRefreshForStaleElement() {
		driver.navigate().refresh();
	}

	public static String getURL() {
		return driver.getCurrentUrl();
	}

	public static String getTextOfEle(By locator) {

		return driver.findElement(locator).getText();
	}

	public static List<String> getTextOfElements(By locator) {

		List<String> text = new ArrayList<String>();
		List<WebElement> web = driver.findElements(locator);

		for (WebElement webElement : web) {
			System.out.println(text.add(webElement.getText()));
		}
		return text;
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static boolean isDisplayedElement(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	static Pattern digit = Pattern.compile("\\d+");
	Pattern doub = Pattern.compile("\\f+");

	public static String extarctNumberFromText(String text) {
		log.info(text);
		Matcher m = digit.matcher(text);
		while (m.find()) {
			System.out.println(m.group());
		}
		return m.group();
	}

	public static int convertStringIntoInteger(String str) {
		return Integer.parseInt(str);
	}

	public static Double convertStringIntoDouble(String str) {
		return Double.parseDouble(str);
	}

	public static String extractNumberFromString(By locator) {
		String text = getTextOfEle(locator);
		System.out.println("text of element=" + text);
		String s = "";
		Matcher m = digit.matcher(text);
		while (m.find()) {
			s = m.group();
		}
		return s;
	}

	public static String extractNumberSFromText(String str) {
		String s = "";
		Matcher m = digit.matcher(str);
		while (m.find()) {
			s = m.group();
		}
		return s;
	}

	public static void moveToElementAction(By by) {
		WebElement ele = driver.findElement(by);
		Actions actions = new Actions(UIKeywords.driver);
		actions.moveToElement(ele).perform();
	}

	public static boolean elementIsEnabled(By locator) {
		// driver.findElement(locator).
		return driver.findElement(locator).isEnabled();
	}

	public static void scrollPageTillElementFound(By locator) {
		JavascriptExecutor js = driver;
		WebElement ele = driver.findElement(locator);
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}

	public static void scrollPageTillOffset(int x, int y) {
		JavascriptExecutor js = driver;
		js.executeScript("window.scrollBy(x,y)");
	}

	public static void bottomPageCount(String str) {
		boolean flag = false;
		do {
			String str1[] = str.split(" ");// page 1 of 2
			for (int i = 0; i < str1.length; i++) {
				log.info(str1[i] + " string ");
			}
			int first = Integer.parseInt(str1[1]);
			int last = Integer.parseInt(str1[3]);

			if (first == last) {
				Assert.assertTrue(true, first + "==" + last);
				flag = true;
				UIKeywords.driver.quit();
			} else {
				UIKeywords.clickOnElement(ObjectRepository.getLocator("nextbuttonpagination"));
				flag = false;
			}
		} while (flag == true);
	}

	public static void sortingLowToHigh(List<WebElement> pricelist) {
		SoftAssert softly = new SoftAssert();

		int i = 0;
		System.out.println("size of list" + pricelist);

		String price[] = new String[pricelist.size()];
		String item[] = new String[pricelist.size()];
		double actualP[] = new double[pricelist.size()];
		double expectedP[] = new double[pricelist.size()];
		for (WebElement webElement : pricelist) {
			item[i] = webElement.getText();
			System.out.print(item[i] + "- ");
			price[i] = UIKeywords.extractNumberSFromText(item[i]);
			System.out.print(price[i] + " p ");
			actualP[i] = UIKeywords.convertStringIntoDouble(price[i]);
			expectedP[i] = actualP[i];
			i++;
		}
		for (int j = 0; j < expectedP.length - 1; j++) {
			for (int k = j + 1; k < expectedP.length; k++) {
				if (expectedP[j] > expectedP[k]) {
					double temp = expectedP[j];
					expectedP[j] = expectedP[k];
					expectedP[k] = temp;
				}
			}
		}
		for (int j = 0; j < expectedP.length - 1; j++) {
			softly.assertEquals(actualP[j], expectedP[j]);
			System.out.println(actualP[j] + "+++==++" + expectedP[j]);
		}
		softly.assertAll();
	}

	public static String getCssValueOfLocator(By locator, String cssvalue) {
		return driver.findElement(locator).getCssValue(cssvalue);
	}
}
