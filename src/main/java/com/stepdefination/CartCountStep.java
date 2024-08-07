package com.stepdefination;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.stauto.UIKeywords.UIKeywords;
import com.stauto.utils.ObjectRepository;
import com.stauto.utils.WaitFor;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartCountStep {
	public static Logger log = LogManager.getLogger();

	@When("I search for perticular product and click on single item and product detail page opened in new tab")
	public void i_search_for_perticular_product_and_click_on_single_item_and_product_detail_page_opened_in_new_tab() {
		String HomeUrl = UIKeywords.driver.getWindowHandle();
		UIKeywords.sendKeysInText(ObjectRepository.getLocator("searchBox"), "decor");
		UIKeywords.clickOnElement(ObjectRepository.getLocator("singleItemOfDecor"));
		Set<String> windowHandles = UIKeywords.driver.getWindowHandles();
		for (String string : windowHandles) {
			if (!(string.equals(HomeUrl))) {
				UIKeywords.driver.switchTo().window(string);
			}
		}
		log.info("searched the product");
	}

	@When("I select size and click on add to bag cta")
	public void i_select_size_and_click_on_cta() {
		UIKeywords.clickOnElement(ObjectRepository.getLocator("selectsize"));
		UIKeywords.clickOnElement(ObjectRepository.getLocator("addtobagcta"));
	}

	@Then("I verify cart count is increased by one")
	public void i_verify_cart_count_is_increased_by_one() {
		WaitFor.waitElementTobeVisible(ObjectRepository.getLocator("cartcount"));
		String str = UIKeywords.getTextOfEle(ObjectRepository.getLocator("cartcount"));
		log.info(str + "= count");
		int i = UIKeywords.convertStringIntoInteger(str);
		Assert.assertEquals(i, 1);
	}
}
