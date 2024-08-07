package com.stepdefination;

import org.testng.Assert;

import com.stauto.UIKeywords.UIKeywords;
import com.stauto.utils.ObjectRepository;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PageCountStep {

	@When("I lauch url")
	public void i_lauch_url() {
		UIKeywords.launchAppURL("chrome");
	}

	@When("I search for perticular product")
	public void i_search_for_perticular_product() {
		UIKeywords.sendKeysInText(ObjectRepository.getLocator("searchBox"), "Nail Bracelet");
	}

	@Then("I verify  page count from bottom")
	public void i_verify_page_count_from_bottom() {
	
		String str = UIKeywords.getTextOfEle(ObjectRepository.getLocator("pagecount"));
					
		UIKeywords.bottomPageCount(str);
		Assert.assertTrue(false);
	}

//	public void bottomPageCount(String str) {
//	//	String str = UIKeywords.getTextOfEle(ObjectRepository.getLocator("pagecount"));
//		///String str = UIKeywords.getTextOfEle(ObjectRepository.getLocator(pagecount));
//		String str1[]=str.split(" ");//page 1 of 2
//		for (int i = 0; i < str1.length; i++) {
//			System.out.println(str1[i]);	
//		}
//		int first=Integer.parseInt(str1[1]);
//		int last=Integer.parseInt(str1[3]);
//		
//		if(first==last) {
//			System.out.println();
//			Assert.assertTrue(true, first+"=="+last);	
//			UIKeywords.driver.quit();
//		}else {
//			
//			//clik on next button
//			//clickelement click
//		}

}


