package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	By signin = By.cssSelector(("a[href*='sign_in']"));
	By title = By.className("text-center");
	By navbar = By.cssSelector(
			"header:nth-child(2) div.navbar.navbar-default.navbar-static-top:nth-child(3) div.container nav.navbar-collapse.collapse > ul.nav.navbar-nav.navbar-right");

	public LandingPage(WebDriver x) {
		driver = x;
	}

	public WebElement getLogin() {

		return driver.findElement(signin);

	}

	public WebElement getTitle() {
		return driver.findElement(title);

	}

	public WebElement getNavbar() {
		return driver.findElement(navbar);

	}
}
