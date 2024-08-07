package com.stepdefination;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import com.stauto.UIKeywords.UIKeywords;
import com.stauto.utils.ObjectRepository;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DonateAmountStep {

	private Logger log;

	@When("I add item in a cart and add item into cart page and click on bag icon")
	public void i_add_item_in_a_cart_and_moved_to_cart_page() {
		log = LogManager.getLogger(this.getClass());
		log.info("In methods ");
		CartCountStep cart = new CartCountStep();
		cart.i_search_for_perticular_product_and_click_on_single_item_and_product_detail_page_opened_in_new_tab();
		cart.i_select_size_and_click_on_cta();
		cart.i_verify_cart_count_is_increased_by_one();
		UIKeywords.clickOnElement(ObjectRepository.getLocator("bagicon"));
		// https://www.myntra.com/checkout/cart
	}

	String normalpill = "";
	String textRs = "";

	@When("I click on Donate checkbox")
	public void i_click_on_donate_checkbox() {
		normalpill = UIKeywords.getCssValueOfLocator(ObjectRepository.getLocator("normalpill"), "color");
		log.info(normalpill);
		log.info(normalpill + " before color");
		UIKeywords.clickOnElement(ObjectRepository.getLocator("donateamountcheckbox"));
		// normalpill= color: #282c3f-- rgba(255, 63, 108, 1);

	}

	@Then("pill View donation Strip of RsTen gets active Pill")
	public void pill_view_donation_strip_of_rs_ten_gets_active_pill() {
		String expected = "rgba(255, 63, 108, 1)";
		String activepill = UIKeywords.getCssValueOfLocator(ObjectRepository.getLocator("normalpill"), "color");
		log.info(activepill + " active pill ");

		Assert.assertNotEquals(normalpill, activepill);
		Assert.assertEquals(expected, activepill);
	}

	@When("I added item into cart and click the donate check box")
	public void i_added_item_into_cart_and_click_the_donate_check_box() {
		i_add_item_in_a_cart_and_moved_to_cart_page();
		i_click_on_donate_checkbox();
		textRs = UIKeywords.getTextOfEle(ObjectRepository.getLocator("normalpill"));
		System.out.println("rs in text= "+ textRs);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("Selected value of Rs Ten is added into the price details")
	public void selected_value_of_rs_ten_is_added_into_the_price_details() {
		String amounttxt = UIKeywords.getTextOfEle(ObjectRepository.getLocator("amountworkdonation"));
		System.out.println("In bill amount ="+amounttxt);
		log.info(amounttxt);
		Assert.assertEquals(amounttxt, textRs);
	}

}
