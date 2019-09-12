package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	public WebElement getCategories(){
		return driver.findElement(By.id("collections"));
	}
	public WebElement getCatSunglasses(){
		return driver.findElement(By.xpath("//img[@alt='stylish sunglasses online']"));
	}
	public WebElement getBasket(){
		return driver.findElement(By.id("showme-shake"));
	}
}