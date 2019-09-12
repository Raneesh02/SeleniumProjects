package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product {
	WebDriver driver;
	public Product(WebDriver driver){
		this.driver=driver;
	}
	
	public WebElement getAddToBasket(){
		return driver.findElement(By.xpath("//input[@value='Add To Basket']"));
	}
	
}
