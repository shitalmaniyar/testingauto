package stauto;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stauto.UIKeywords.UIKeywords;
import com.stauto.pages.PageProductDescription;

public class productDescriTest extends BaseClass {

	// PageProductDescription pageProdDescription=new PageProductDescription();
	@Test
	public void verifyShoeCount() {

		PageProductDescription page = PageFactory.initElements(UIKeywords.driver, PageProductDescription.class);
		page.sendKeysInSearchBox("shoes");

		page.checkboxCategires();
		String productCount = page.getCount(page.productCount);
		System.out.println(productCount);
		String titleCount = page.getCount(page.titleCount);
		System.out.println(titleCount);
		Assert.assertEquals(productCount, titleCount);
	}

	@Test
	public void verifyRatingDisplyedAboveThree() {

		PageProductDescription pageProdDescription = PageFactory.initElements(UIKeywords.driver,
				PageProductDescription.class);
		pageProdDescription.hoverOnMenSection();
		System.out.println("men section opened");
		pageProdDescription.clickOnTshirtMenOptions();
		List<Double> ratingList = pageProdDescription.getTextOfRating();
		for (int i = 0; i < ratingList.size(); i++) {
			if (ratingList.get(i) > 3) {
				System.out.println(ratingList.get(i));
			}
		}
	}
}
