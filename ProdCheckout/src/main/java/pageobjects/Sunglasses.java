package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sunglasses {
	WebDriver driver;
	public Sunglasses(WebDriver driver){
		this.driver=driver;
	}
	
	
	public WebElement getBrandFilter(){
		return driver.findElement(By.id("brandAlias"));
	}
	public WebElement getBrandJRSFilter(){
		return driver.findElement(By.id("JRS"));
	}
	public List<WebElement> getProductList(){
		return driver.findElements(By.xpath("//div[@class='product-grid']/ul/li"));
	}
	
}
