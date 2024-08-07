package com.stepdefination;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.stauto.UIKeywords.UIKeywords;
import com.stauto.utils.Envirnoment;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	public static final Logger log = LogManager.getLogger(Hooks.class);

	@Before(order = 0)
	public void setUp() {
		UIKeywords.launchAppURL(Envirnoment.getBrowserName());
		log.info("Browser launched in logs");
	}

	@After(order = 1)
	public void takeScraenshotOnFailure(Scenario scenario) {

		if (scenario.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) UIKeywords.driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "screenshot");
		}

	}

	@After(order = 0)
	public void tearDown() {
		UIKeywords.closeBrowser();
		log.info("Browser closed..");
	}
}
