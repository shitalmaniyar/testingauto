package stauto;

import org.testng.annotations.Test;

import com.stauto.pages.AddToBagPage;

public class cart extends BaseClass{

	
	@Test

	public void verifyItemAddedinBagIsMatchedWithActual() {
		
		AddToBagPage page=new AddToBagPage();
		TestHome home=new TestHome();
		home.verifyItemAddingIntoCart();
		String productDetailText=page.getTextOfProductDetail();
		System.out.println(productDetailText);
		
	}
}
