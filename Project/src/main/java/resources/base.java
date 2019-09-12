package resources;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	private WebDriver driver;
	public static Properties projectProperties;

	public WebDriver getDriver() {
		return driver;
	}

	public WebDriver initializeDriver() throws IOException {
		FileReader reader = new FileReader("./resources/project.properties");
		projectProperties = new Properties();
		projectProperties.load(reader);
		String browserName = projectProperties.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./BrowserDriver/chromedriver/" + "chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./BrowserDriver/chromedriver/" + "chromedriver.exe");
			driver = new FirefoxDriver();

		} else {
			System.setProperty("webdriver.ie.driver", "D:\\Selenium\\IEDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
	}

	public void getScreenshot(String filename) throws IOException {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\Selenium\\" + filename + ".png"));
	}

}
