package common;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import resources.base;

public class TestSuite extends base {

	@BeforeTest
	public void initializeTest() throws IOException {
		Runtime.getRuntime().exec("taskkill /f /im chromedriver.exe");
		initializeDriver();
		getDriver().manage().window().maximize();
		getDriver().get(projectProperties.getProperty("url"));

	}

	@AfterTest
	public void tearDownTest() {
		getDriver().close();
		getDriver().quit();
	}
}
