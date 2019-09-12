package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import common.TestSuite;
import pageobjects.LandingPage;

public class validateNavbar extends TestSuite {

	@Test(invocationCount = 10, threadPoolSize = 5)
	public void basePageNavigation() throws IOException {
		LandingPage l = new LandingPage(getDriver());
		// compare the text from browser with actual value
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(l.getNavbar().isDisplayed(), true);
		Assert.assertTrue(l.getNavbar().isDisplayed());
		System.out.println("Hey");
		softAssert.assertAll();
	}

}
