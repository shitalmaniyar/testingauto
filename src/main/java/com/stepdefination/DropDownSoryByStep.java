package com.stepdefination;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import com.stauto.UIKeywords.UIKeywords;
import com.stauto.utils.ObjectRepository;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DropDownSoryByStep {

//	@When("I launch the browser")
//	public void i_launch_the_browser() {
//		UIKeywords.launchAppURL("chrome");
//	}

	@When("search for perticular item")
	public void search_for_perticular_item() {
		UIKeywords.sendKeysInText(ObjectRepository.getLocator("searchBox"), "decor");
	}

	@When("I click on sort by drop down and click on Low to High option")
	public void i_click_on_sort_by_drop_down_and_click_on_low_to_high_option() {
		UIKeywords.moveToElementAction(ObjectRepository.getLocator("sortbydropdown"));
		UIKeywords.moveToElementAction(ObjectRepository.getLocator("lowtohighsort"));
		UIKeywords.clickOnElement(ObjectRepository.getLocator("lowtohighsort"));
		UIKeywords.moveToElementAction(ObjectRepository.getLocator("wishlisticon"));
	}

	@Then("I verify price of items are sorted in low to high order")
	public void i_verify_price_of_items_are_sorted_in_low_to_high_order() {
		List<WebElement> pricelist = UIKeywords.getElements(ObjectRepository.getLocator("pricesofallitems"));
		UIKeywords.sortingLowToHigh(pricelist);
	}

	@Then("I verify price of items are sorted in low to high order and I click on next button to verify all price are sorted in low to high until button is unable")
	public void i_verify_price_of_items_are_sorted_in_low_to_high_order_and_i_click_on_next_button_to_verify_all_price_are_sorted_in_low_to_high_until_button_is_unable() {
		SoftAssert softly = new SoftAssert();
		boolean f = true;
		do {
			List<WebElement> pricelist = UIKeywords.getElements(ObjectRepository.getLocator("pricesofallitems"));
			UIKeywords.sortingLowToHigh(pricelist);
			UIKeywords.clickOnElement(ObjectRepository.getLocator("nextbuttonpagination"));
			f = UIKeywords.isDisplayedElement(ObjectRepository.getLocator("nextbuttonpagination"));
			System.out.println(f + "condition");
			softly.assertTrue(f, "next button clicked");

		} while (f != false);
		softly.assertAll();	}
}
