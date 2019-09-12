package Coolwinks;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.HomePage;
import pageobjects.Product;
import pageobjects.Sunglasses;
import resources.base;

public class JRSglassesCheckout extends base{
	HomePage home;
	Sunglasses sunglasses;
	Actions actions;
	Product productpage;
	WebDriverWait  wait1;
	private final static Logger logger=Logger.getLogger(JRSglassesCheckout.class);
	
	@BeforeTest
	private void init() throws IOException {
		DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\"+"log4j.xml");
		logger.info("Logger initalized");
		initializeDriver();
		home=new HomePage(driver);
		actions=new Actions(driver);
		wait1=new WebDriverWait(driver, 10);
		sunglasses=new Sunglasses(driver);
		productpage=new Product(driver);
		logger.info("Driver initialized successfully");
	}	
	
	@Test
	public void homepagenavigation(){
		
		driver.get("https://www.coolwinks.com/");
		driver.manage().window().maximize();
		Assert.assertTrue(driver.getTitle().contains("Coolwinks.com"));
		driver.findElement(By.cssSelector("span.hm_close.close")).click();
		logger.info("Homepage is accessible");
	}
	
		public void gotoSunglassesPage() throws InterruptedException{
			Thread.sleep(5000);
			actions.moveToElement(home.getCategories()).build().perform();
			assertTrue(home.getCatSunglasses().isDisplayed());
			//wait1.until(ExpectedConditions.visibilityOf(home.getCatSunglasses()));
			home.getCatSunglasses().click();		
			logger.info("Sunglasses page is launched.");
		}
	
		@Test(dependsOnMethods = { "homepagenavigation"})
		public void JRScheckout() throws IOException, InterruptedException 
		{
		// TODO Auto-generated method stub		
			
		//Go to Sunglasses Page
		gotoSunglassesPage();
		
		//apply filter
		sunglasses.getBrandFilter().click();
		sunglasses.getBrandJRSFilter().click();
		logger.info("Filter applied successfully");
		
		int productlistsize=sunglasses.getProductList().size();
		Thread.sleep(5000);
		
		//find last glass on the page
		WebElement lastglass=sunglasses.getProductList().get(productlistsize-1); 
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",sunglasses.getProductList().get(productlistsize-4));
		
		getScreenshot("LastGoggle");//save the screenshot of last google
		
		//Go to product page
		lastglass.click();
		logger.info("Product page is launched.");		
		
		getScreenshot("ProductPage"); //Product page
		
		//Test Add to Basket 
		productpage.getAddToBasket().click();
		getScreenshot("CheckoutPage");
		home.getBasket().click();
		logger.info("Basket addition is launched.");		
		
	}
		
		@AfterTest
		public void teardown(){
			System.out.println("Browser is closing");
			driver.quit();
			driver=null;
		}
}
