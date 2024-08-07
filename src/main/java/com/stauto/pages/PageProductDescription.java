package com.stauto.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stauto.UIKeywords.UIKeywords;

public class PageProductDescription {

	public PageProductDescription() {
		PageFactory.initElements(UIKeywords.driver, PageProductDescription.class);
	}

	@FindBy(css = "ul.categories-list>li:nth-child(1)")
	public WebElement categories;

	public void checkboxCategires() {
		categories.click();
	}

	@FindBy(css = "input.desktop-searchBar")
	public WebElement searchBox;

	public void sendKeysInSearchBox(String productName) {

		searchBox.sendKeys(productName, Keys.ENTER);

	}

	@FindBy(css = "a[data-group*='men']")
	WebElement menSection;

	// h4.product-product text of item
	@FindBy(css = "span.categories-num")
	public WebElement productCount;

	@FindBy(css = "a[href*='/men-tshirts']")
	WebElement TshirtMenSection;

	// @FindBy(css = "div.product-ratingsContainer>span")
	@FindBy(xpath = "//div[@class='product-ratingsContainer']/span[1]")
	List<WebElement> ratingProduct;

	@FindBy(css = "span.title-count")
	public WebElement titleCount;

	public void hoverOnMenSection() {
		Actions actions = new Actions(UIKeywords.driver);
		actions.moveToElement(menSection).perform();
	}

	public void clickOnTshirtMenOptions() {
		TshirtMenSection.click();
	}

	public List<Double> getTextOfRating() {
		List<Double> RatingL = new ArrayList<Double>();
		for (WebElement rate : ratingProduct) {
			RatingL.add(Double.parseDouble(rate.getText()));

		}
		return RatingL;
	}

	Pattern digit = Pattern.compile("\\d+");

	Pattern doub = Pattern.compile("\\f+");

	public String getCount(WebElement ele) {

		String count = ele.getText();
		// System.out.println(count);
		Matcher m = digit.matcher(count);
		while (m.find()) {
			System.out.println(m.group());
		}
		return m.group();
	}

}
