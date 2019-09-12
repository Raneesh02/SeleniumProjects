package Academy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import common.TestSuite;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class Homepage extends TestSuite {

	@Test(dataProvider = "getData", enabled = false)
	public void basePageNavigation(String username, String password, String text) throws IOException {
		// as data provider is used. so this getDriver().get has to be in this
		// method
		// only.

		LandingPage landingpage = new LandingPage(getDriver());
		landingpage.getLogin().click();
		LoginPage lp = new LoginPage(getDriver());
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(getDriver());
		wait.withTimeout(java.time.Duration.ofSeconds(20)).pollingEvery(java.time.Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(lp.getEmail()));
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		System.out.println(text);
		lp.getLogin().click();

	}

	@DataProvider
	public String[][] getData() {
		// Row stands for how many different data.
		// Column stands for how many values per each test
		String[][] data = new String[2][3];
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Non Restricted User";

		data[1][0] = "restrictedUser@gma.com";
		data[1][1] = "324232";
		data[1][2] = "RestrictedUser";

		// Object[] bigdata = new Object[3];
		// bigdata[0] = "restrictedUser@gma.com";
		// bigdata[1] = "324232";
		// bigdata[2] = "RestrictedUser";

		return data;
	}

	@DataProvider
	public Iterator<String> getFucker() {
		ArrayList<String> list = new ArrayList<>();

		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		// return list.iterator();

		String[] s = { "feaw", "fewaio" };
		return null;

	}

	@Test(dataProvider = "getFucker")
	void test(String s) {
		System.out.println(s);
	}

}
