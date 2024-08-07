package com.stauto.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.stauto.UIKeywords.UIKeywords;

public class HomePage {
	// a[data-group*='women']

//	public HomePage() {
//		PageFactory.initElements(UIKeywords.driver, HomePage.class);
//	}

	@FindBy(css ="a.desktop-cart")
	public WebElement BagIcon;

	@FindBy(css = "div.pdp-add-to-bag.pdp-button.pdp-flex.pdp-center")
	public WebElement addToBagCta;

	@FindBy(css = "div.size-buttons-buttonContainer")
	public WebElement selectSize;

	public void clickOnElement(WebElement ele) {
		ele.click();
	}

	public void clickOnSelectSize() {
		selectSize.click();
	}

	@FindBy(css = "a.myntraweb-sprite.desktop-logo")
	public WebElement logo;

	@FindBy(css = "div.desktop-navContent")
	public List<WebElement> headerSectionLink;

	@FindBy(css = "div.emptyCart-base-emptyDesc")
	public WebElement bagEmpty;

	@FindBy(css = "input.desktop-searchBar")
	public WebElement searchBox;

	@FindBy(css = "span.myntraweb-sprite.desktop-iconBag")
	public WebElement bag;

	@FindBy(css = "span.desktop-badge")
	public WebElement badgeBag;

	@FindBy(css = "span.product-discountedPrice")
	public List<WebElement> priceL;

	@FindBy(xpath = "(//span[@class='product-discountedPrice'])[10]")
	public WebElement singleItemOfDecor;

	public void clickOnsingleItemOfDecor() {
		singleItemOfDecor.click();
	}

	public void clickOnLogo() {
		logo.click();
	}

	public List<String> getTextOfHectionSection() {
		List<String> text = new ArrayList<String>();
		for (WebElement ele : headerSectionLink) {
			text.add(ele.getText());
		}
		return text;
	}

	public void clickOnBag() {
		bag.click();
	}

	public String getTextEmptyBag() {
		return bagEmpty.getText();
	}

	public void sendKeysInSearchKey(String str) {
		searchBox.sendKeys(str, Keys.ENTER);
	}

	@FindBy(css = "div.sort-sortBy")
	public WebElement filterDropdown;

	public void clickOnFilter() {

		UIKeywords.actionsMoveToElement(filterDropdown);
		// filterDropdown.click();
	}

	// div.sort-sortBy>ul>li:nth-child(6)
	@FindBy(css = "div.sort-sortBy>ul>li:nth-child(6)")
	public WebElement filterLowToHigh;

	public void clickOnLowToHigh() {
		((JavascriptExecutor) UIKeywords.driver).executeScript("arguments[0].click();", filterLowToHigh);
		Actions actions = new Actions(UIKeywords.driver);
		actions.moveToElement(filterLowToHigh).perform();
		filterLowToHigh.click();
		// actions.moveByOffset(500, 300).perform();

	}

	public List<String> extarctPriceFromRs() {
		List<String> priceList = new ArrayList<String>();

		for (int i = 0; i < priceL.size(); i++) {
			priceList.add(priceL.get(i).getText());
		}

		return priceList;
	}

}
