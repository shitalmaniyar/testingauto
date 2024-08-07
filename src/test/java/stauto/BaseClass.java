package stauto;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.stauto.UIKeywords.UIKeywords;
import com.stauto.utils.Envirnoment;

public class BaseClass {
	
	
	@BeforeMethod
	public void setUp() {
		UIKeywords.launchAppURL(Envirnoment.getBrowserName());
	}
	@AfterMethod
	public void tearDown() {
		UIKeywords.closeBrowser();
	}
}
