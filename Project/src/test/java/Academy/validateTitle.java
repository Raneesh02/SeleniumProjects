package Academy;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.TestSuite;
import pageobjects.LandingPage;
import resources.base;

public class validateTitle extends TestSuite {
	public static Logger log = org.apache.log4j.LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		log.info("getDriver() is initialized");
		log.info("URL is initialized");
		log.warn("dfaioejwoifj dofij inistilizeled");
	}

	@Test
	public void basePageNavigation() throws IOException {
		LandingPage l = new LandingPage(getDriver());
		// compare the text from browser with actual value
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");

	}

}
