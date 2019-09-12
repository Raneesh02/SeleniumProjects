package kheladdatest;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.Cricket;
import pageobjects.HomePage;
import resources.Base;

public class VerifyCricketCat {
	HomePage homepage;
	Cricket cricketpage;
		private final static Logger logger=Logger.getLogger(VerifyHomePage.class);
		@BeforeTest
		public void init() throws IOException{
		DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\"+"log4j.xml");	
		homepage=new HomePage();
		cricketpage=new Cricket();
		logger.info("Classlevel initialization complete");
		
		}	
	@Test
	public void VerifyCricketBats() throws InterruptedException{
	homepage.getCricketMenuOption("CRICKET").click();
	cricketpage.getCricketFilter("Cricket Bats").click();
	cricketpage.getfilterApplybtn().click();
	Thread.sleep(5000);
	int n=cricketpage.getTotalPages();
	logger.info("Total no of pages"+n);
	//checkProductList();
	for(int i=1;i<=n;i++){
		logger.info("Testing Page "+i);
		checkProductList();
		if(i!=n)
		cricketpage.gotoPage(i+1);	
	}
	}
	
	public void checkProductList(){
		List<WebElement> productlist=cricketpage.getProductDesclist();
		//logger.info("Product list size: "+productlist.size());
		Iterator<WebElement> it=productlist.iterator();
		String url;
		int i=0;
		while(it.hasNext()){
			url=it.next().getAttribute("href");
			//Assertion for presence of bat in URL
			Assert.assertTrue(Pattern.compile(Pattern.quote("bat"), Pattern.CASE_INSENSITIVE).matcher(url).find());
			i++;
		}
		logger.info("Total products tested on this page:"+i);
	}
	
}
