package com.stepdefination;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		//plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		
		features = {"src/test/resources/com/Features/DonateAmount.feature"}, 
		glue = {"com.stepdefination"} ,dryRun=true
		
)

public class TestRunner extends AbstractTestNGCucumberTests {
	// Logger log = LogManager.getLogger(this.getClass());

}
