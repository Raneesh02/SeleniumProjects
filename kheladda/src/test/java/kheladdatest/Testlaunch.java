package kheladdatest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testlaunch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\BrowserDriver\\geckodriver\\"+"geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\EclipseworkSpace\\selenium\\BrowserDriver\\chromedriver\\chromedriver.exe");	
		// launch the browser
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.google.com");
	}

}
