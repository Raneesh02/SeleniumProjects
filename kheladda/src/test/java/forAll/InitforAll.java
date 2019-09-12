package forAll;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import resources.Base;

public class InitforAll {
@BeforeSuite
public void init() throws IOException{
	Base.initializeDriver();	
	Base.driver.get(Base.homepageURL);
	Base.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}


@AfterSuite
public void teardown() throws InterruptedException{
	Thread.sleep(5000);
	Base.driver.quit();
	Base.driver=null;
	} 
}

