package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	public WebDriver driver;
	By email=By.id("user_email");
	By password=By.id("user_password");
	By submit=By.cssSelector("input[value='Log In']");
	public LoginPage(WebDriver x){
		driver=x;
	}
	
	
	
	
	public WebElement getEmail(){
		return driver.findElement(email);
		
	}
	
	public WebElement getPassword(){
		return driver.findElement(password);
		
	}
	public WebElement getLogin(){
		return driver.findElement(submit);
		
	}
}
