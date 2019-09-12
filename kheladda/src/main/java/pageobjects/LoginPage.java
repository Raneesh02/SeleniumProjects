package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public static WebDriver driver;
	
	public WebElement getUsername(){
		return driver.findElement(By.id("username"));
	}
	
	public WebElement getPass(){
		return driver.findElement(By.id("password"));
	}
	public WebElement getSubmit(){
		return driver.findElement(By.xpath("[@id='reset')"));
	}
}
