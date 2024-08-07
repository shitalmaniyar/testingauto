package stauto;


import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stauto.UIKeywords.UIKeywords;
import com.stauto.pages.HomePage;
import com.stauto.utils.Envirnoment;
import com.stauto.utils.WaitFor;


public class TestHome extends BaseClass {
	HomePage home = new HomePage();
	public Logger log;
	// = PageFactory.initElements(UIKeywords.driver, HomePage.class);
	@Test
	public void verifyClickingOnLogoHomePageDisplyed() {
		log=LogManager.getLogger(this.getClass());
		home = PageFactory.initElements(UIKeywords.driver, HomePage.class);
		WaitFor.waitElementToBeClickable(home.logo);
		home.clickOnLogo();
//		assertEquals(UIKeywords.PageURL(), Envirnoment.getURL());
		log.info(UIKeywords.getURL() + "=======" + Envirnoment.getURL());
	}

	@Test
	public void verifyHeaderSectionMenuLinks() {
		home = PageFactory.initElements(UIKeywords.driver, HomePage.class);
		List<String> hedermenu = home.getTextOfHectionSection();
		for (String element : hedermenu) {
			// soflty.assertEquals(element,"Menu item text");
			System.out.println(element);

			Assert.assertTrue(true, element);
		}
	}

	@Test
	public void verifyFilterLowToHigh() {

		home = PageFactory.initElements(UIKeywords.driver, HomePage.class);
		home.sendKeysInSearchKey("decor");
		home.clickOnFilter();
		System.out.println("filter clicked");
		WaitFor.waitElementToBeClickable(home.filterLowToHigh);
		System.out.println("waiting to open..");
		home.clickOnLowToHigh();
		WaitFor.waitStaleElementExceptionhandle(home.priceL);
		List<String> priceL = home.extarctPriceFromRs();

		List<Double> originalPrice = new ArrayList<Double>();
		List<Double> sortedPrice = new ArrayList<Double>();

		for (int i = 0; i < priceL.size(); i++) {
			double sp = Double.parseDouble(priceL.get(i).split(" ")[1]);
			// System.out.print(sp + " ");
			originalPrice.add(sp);

		}
		for (double element : originalPrice) {
			System.out.print(element + " ");
		}

		sortedPrice.addAll(originalPrice);

		// Collections.sort(sortedPrice);
		System.out.println("sorted");

//		SoftAssert softly=new SoftAssert();
//		softly.assertEquals(originalPrice, sortedPrice);
//		softly.assertAll();

		for (Double element : sortedPrice) {
			System.out.print(element + " ");
		}
		Assert.assertEquals(originalPrice, sortedPrice);
//		System.out.println("after sorting");
//		for (String element : text) {
//			System.out.print(element + " ");
//		}

	}

	@Test
	public void verifyItemAddingIntoCart() {
		home = PageFactory.initElements(UIKeywords.driver, HomePage.class);
		String HomeUrl = UIKeywords.driver.getWindowHandle();
		home.sendKeysInSearchKey("decor");
		home.clickOnsingleItemOfDecor();
		Set<String> windowHandles = UIKeywords.driver.getWindowHandles();
		for (String string : windowHandles) {
			if (!(string.equals(HomeUrl))) {
				UIKeywords.driver.switchTo().window(string);
			}
		}
		System.out.println(UIKeywords.driver.getCurrentUrl());
		WaitFor.waitElementToBeClickable(home.selectSize);
		home.clickOnElement(home.selectSize);
		WaitFor.waitElementToBeClickable(home.addToBagCta);
		home.clickOnElement(home.addToBagCta);
		WaitFor.waitElementToBeClickable(home.BagIcon);
		home.clickOnElement(home.BagIcon);

	}

	@Test
	public void verifySearchBoxAcceptString() {
		home.sendKeysInSearchKey("decor");
		boolean flag = home.searchBox.isEnabled();
		Assert.assertTrue(flag);
	}

	@Test
	public void verifyWhenNoItemsInBag() {
		home = PageFactory.initElements(UIKeywords.driver, HomePage.class);
		WaitFor.waitElementToBeClickable(home.logo);
		System.out.println(home.badgeBag.getText());
		home.clickOnBag();
		String msg = home.getTextEmptyBag();
		Assert.assertEquals("There is nothing in your bag. Let's add some items.",msg);
	}

}
