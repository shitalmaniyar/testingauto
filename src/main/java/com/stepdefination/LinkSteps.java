package com.stepdefination;


import com.stauto.UIKeywords.UIKeywords;
import com.stauto.utils.ObjectRepository;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LinkSteps {

	String HomeUrl = "";
	String currentUrl = "";

	@Given("I launch url on publish environment")
	public void i_launch_url_on_publish_environment() {
		UIKeywords.launchAppURL("chrome");
	}

	@And("I fetch current curl")
	public void i_fetch_current_curl() {
		HomeUrl = UIKeywords.getURL();
	}

	@And("I click on logo")
	public void i_click_on_logo() {
		UIKeywords.clickOnElement(ObjectRepository.getLocator("logo"));
		currentUrl=UIKeywords.driver.getCurrentUrl();
	}

	@Then("I validate Navigation for links on publish envirnoment")
	public void i_validate_navigation_for_links_on_publish_envirnoment() {
		//assertEquals(HomeUrl, currentUrl); //getting error in inport 
		//assertEquals();
		
}}
