package kheladdatest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Cricket;
import pageobjects.HomePage;
import resources.Base;


public class VerifySearch {
	private final static Logger logger=Logger.getLogger(VerifyHomePage.class);
	HomePage homepage;
	Cricket cricketpage;
	
	@BeforeTest
	public void init() throws IOException{
	DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\"+"log4j.xml");	
	logger.info("Classlevel initialization complete");
	homepage=new HomePage();	
	cricketpage=new Cricket();
	}

	@Test
	public void verifysearch() throws IOException{
		homepage.getSearchBox().sendKeys("Bat");
		homepage.getSearchButton().click();
		List<WebElement> productlist=cricketpage.getProductDesclist();
		//logger.info("Product list size: "+productlist.size());
		Iterator<WebElement> it=productlist.iterator();
		String url;
		int i=0;
		while(it.hasNext()){
			url=it.next().getText();
			System.out.println(url);
			//Assertion for presence of bat in URL
			Assert.assertTrue(Pattern.compile(Pattern.quote("bat"), Pattern.CASE_INSENSITIVE).matcher(url).find());
			i++;
		}
		logger.info("Total products tested on this page:"+i);
	}
}
