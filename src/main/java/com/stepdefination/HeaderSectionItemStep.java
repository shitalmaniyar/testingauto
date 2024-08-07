package com.stepdefination;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.stauto.UIKeywords.UIKeywords;
import com.stauto.utils.ObjectRepository;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HeaderSectionItemStep {
	Logger log = LogManager.getLogger("CartCountStep");
	SoftAssert softly = new SoftAssert();

	@Then("I get list of header menu items")
	public void i_get_list_of_header_menu_items() {
		String expectedString[] = { "MEN", "WOMEN", "KIDS", "HOME & LIVING", "BEAUTY", "STUDIO NEW" };
		String actualString[] = new String[expectedString.length];
		List<WebElement> ele = UIKeywords.getElements(ObjectRepository.getLocator("headerSectionLink"));

		for (int i = 0; i < ele.size(); i++) {
			actualString[i] = ele.get(i).getText();
			log.info("actual log " + actualString[i]);
			softly.assertEquals(expectedString[i], actualString[i]);
		}
		softly.assertAll();
	}

//	@When("I launch url")
//	public void i_launch_url() {
//		UIKeywords.launchAppURL("chrome");
//	}

	@When("click on cart menu icon")
	public void click_on_cart_menu_icon() {
		UIKeywords.clickOnElement(ObjectRepository.getLocator("cart"));
	}

	@Then("empty cart icon opens a cart link with message")
	public void empty_cart_icon_opens_a_cart_link_with_message() {
		// user soft assert to validate both condition
		String cartLinnk = UIKeywords.getURL();
		String expectedLink = "https://www.myntra.com/checkout/cart";
		Assert.assertEquals(expectedLink, cartLinnk);

		String msg = UIKeywords.getTextOfEle(ObjectRepository.getLocator("bagEmpty"));
		Assert.assertEquals("There is nothing in your bag. Let's add some items.", msg);
		// System.out.println(msg);
	}

//	@When("I launched url")
//	public void i_launched_url() {
//		UIKeywords.launchAppURL("chrome");
//	}

	@When("I click on wishlist icon")
	public void i_click_on_wishlist_icon() {
		UIKeywords.clickOnElement(ObjectRepository.getLocator("wishlisticon"));
		log.info("click on wishlink");
	}

	@Then("login is asked on wishlist redirectional link")
	public void login_is_asked_on_wishlist_redirectional_link() {
		String expectedWishListLink = "https://www.myntra.com/wishlist";
		String cartLink = UIKeywords.getURL();
		log.info(cartLink + "--log of cart link");
		Assert.assertEquals(expectedWishListLink, cartLink);
		log.info("Logs working");
		boolean flag = UIKeywords.isDisplayedElement(ObjectRepository.getLocator("loginbuttononwishlist"));
		Assert.assertTrue(flag);
	}
}
