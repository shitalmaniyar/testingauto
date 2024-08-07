package com.stauto.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.stauto.UIKeywords.UIKeywords;

public class AddToBagPage{
	
	
	public AddToBagPage() {
		PageFactory.initElements(UIKeywords.driver, this);
	}
	@FindBy(css="div.pdp-price-info")
	WebElement productDescription;
	
	public String getTextOfProductDetail(){
		
		return productDescription.getText();
	}
	
}
