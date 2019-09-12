package resources;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public static WebDriver driver;

	public static WebDriver initializeDriver() throws IOException {
		String browserName = "chrome";
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\BrowserDriver\\chromedriver\\" + "chromedriver.exe");
			driver = new ChromeDriver();
			// execute in chrome driver

		} else if (browserName.equals("firefox")) {
			// driver= new FirefoxDriver();
			// firefox code
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\BrowserDriver\\geckodriver\\" + "geckodriver.exe");
			driver = new FirefoxDriver();

		}

		else if (browserName.equals("IE")) {
			// IE code
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public static void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\output\\" + result + "screenshot.png"));

	}
}