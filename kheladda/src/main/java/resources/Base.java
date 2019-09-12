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
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class Base {

public static String homepageURL="https://kheladda.in/";
public static WebDriver driver;
public static WebDriver initializeDriver() throws IOException

{
String browserName="firefox";	
System.out.println(browserName);

if(browserName.equals("chrome"))
{
	 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserDriver\\chromedriver\\"+"chromedriver.exe");
	driver= new ChromeDriver();
		//execute in chrome driver
	
}
else if (browserName.equals("firefox"))
{
	 //driver= new FirefoxDriver();
	//firefox code
	FirefoxOptions ops=new FirefoxOptions();
	ops.addArguments("--disable-notifications");
	
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\BrowserDriver\\geckodriver\\"+"geckodriver.exe");
	System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
	System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
	driver= new FirefoxDriver(ops);
	
}

else if (browserName.equals("IE"))
{
//	IE code
}
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



return driver;
}

static public void getScreenshot(String result) throws IOException
{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\output\\"+result+"screenshot.png"));
	
}

}
