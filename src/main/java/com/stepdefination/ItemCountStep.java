package com.stepdefination;

import org.testng.Assert;

import com.stauto.UIKeywords.UIKeywords;
import com.stauto.utils.ObjectRepository;
import com.stauto.utils.WaitFor;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ItemCountStep {

	String text;

//	@When("I lauched browser")
//	public void i_lauched_browser() {
//		UIKeywords.launchAppURL("chrome");
//	}

	@When("search for procduct from searchbox and hit enter")
	public void search_for_procduct_from_searchbox_and_hit_enter() {
		UIKeywords.sendKeysInText(ObjectRepository.getLocator("searchBox"), "shoes");
	}

	@Then("page navigates on product detail page")
	public void page_navigates_on_product_detail_page() {
		String expectedUrl = "https://www.myntra.com/shoes?rawQuery=shoes";
		String actualurl = UIKeywords.getURL();
		Assert.assertEquals(expectedUrl, actualurl);
	}

	int actualcategorycount = 0;

	@When("I fetch perticular category count from checkbox")
	public void i_fetch_perticular_item_count_from_checkbox() {

		System.out.println("loc**=" + ObjectRepository.getLocator("categorycount"));
		String numbertxt = UIKeywords.extractNumberFromString(ObjectRepository.getLocator("categorycount"));
		System.out.println(numbertxt + "sadkjflkl***********");
		actualcategorycount = UIKeywords.convertStringIntoInteger(numbertxt);
		System.out.println(actualcategorycount + "actual count **");
	}

	@Then("I click on  perticular category checkbox")
	public void i_click_on_perticular_category_checkbox() {
		WaitFor.waitElementToBeClickable(ObjectRepository.getLocator("categorychecckbox"));
		UIKeywords.clickOnElement(ObjectRepository.getLocator("categorychecckbox"));
		System.out.println("checbox clicked ..........");
	}

	/**
	 * This method takes the input string and return number from string
	 */

	@Then("verify fetched count matched with title count")
	public void verify_fetched_count_matched_with_title_count() {
		System.out.println();
		String numbertxt = UIKeywords.extractNumberFromString(ObjectRepository.getLocator("titlecount"));
		int titlecount = UIKeywords.convertStringIntoInteger(numbertxt);
		System.out.println(titlecount + "title count");
		Assert.assertEquals(titlecount, actualcategorycount);
	}

}
