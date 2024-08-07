package com.stepdefination;

import java.util.List;

import org.testng.asserts.SoftAssert;

import com.stauto.UIKeywords.UIKeywords;
import com.stauto.utils.ObjectRepository;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchAndSelectStep {

	@When("I serach for {string} in search box and select one option from suggestion")
	public void i_serach_for_in_search_box_and_select_one_option_from_suggestion(String string) {
		UIKeywords.sendKeysInTextNotEnter(ObjectRepository.getLocator("searchBox"), string);
		UIKeywords.clickOnElement(ObjectRepository.getLocator("searchselect"));
	}

	@Then("I verify text of suggested item is avialble in all products")
	public void i_verify_text_of_suggested_item_is_avialble_in_all_products() {
		SoftAssert softly=new SoftAssert();
		List<String> str = UIKeywords.getTextOfElements(ObjectRepository.getLocator("itemtext"));
		System.out.println("before loop");
		for (String string : str) {
			softly.assertTrue(string.contains("deco"));  
		}
		softly.assertAll();

	}
}
