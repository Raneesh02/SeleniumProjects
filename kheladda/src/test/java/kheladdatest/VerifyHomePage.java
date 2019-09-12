package kheladdatest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import resources.Base;

public class VerifyHomePage {
	private final static Logger logger=Logger.getLogger(VerifyHomePage.class);
	HomePage homepage;
	@BeforeTest
	public void init() throws IOException{
	DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\"+"log4j.xml");	
	homepage=new HomePage();
	logger.info("Classlevel initialization complete");
	}
	
	
	@Test
	public void TestAlllinks() throws IOException{
	
	List<WebElement> allinkslist=homepage.getAlllinks();
	logger.info("Total linkes on this Page: "+allinkslist.size());
	Iterator<WebElement> listit=allinkslist.iterator();
	WebElement oneelement;
	String pagelink;

	 Set<String> pagelinks = new HashSet<String>();
	Byte nullcount=0;
	while(listit.hasNext()) {
		oneelement=listit.next();
		pagelink=oneelement.getAttribute("href");
		
		if(pagelink==null){
		//	logger.error("Link is null for this"+oneelement.getText()+" "+oneelement.getLocation());
			nullcount++;
			continue;
		}
		else if(pagelink.contains("javascript:void(0)")){
			continue;
		}
		else if(!pagelink.contains("https")){
			pagelink=pagelink.replace("http", "https");
		}
		pagelinks.add(pagelink);
	}
	logger.error("Total null links in page"+nullcount);
	logger.info("Total unique links in page"+pagelinks.size());
	Iterator<String> it=pagelinks.iterator();
	
	ArrayList<String> passlink=new ArrayList<String>(20);
	ArrayList<String> faillink=new ArrayList<String>(20);
	String resp;
	while(it.hasNext()) {
	pagelink=it.next();
	resp=checklink(pagelink);
	if(!resp.equals("OK")){
	faillink.add(pagelink+" "+resp);
	}
	else{
	passlink.add(pagelink);	
	}
	}
	logger.info("Pass links");
	it=passlink.iterator();
	String passlinkit;
	ArrayList<String> passlinkxp=new ArrayList<String>(passlink);
	while(it.hasNext()){
		passlinkit=it.next();
		try{
			Base.driver.get(passlinkit);
		}
		catch(WebDriverException e){
			logger.error("Caught one exception link");
			passlinkxp.remove(passlinkit);
			faillink.add(passlinkit+" page is not accessible");
		}
	}
	
	logger.info("Fail links");
	it=faillink.iterator();
	while(it.hasNext()){
		System.out.println(it.next());
	}
	
	logger.info("pass links");
	it=passlinkxp.iterator();
	while(it.hasNext()){
		System.out.println(it.next());
	}
	
	
	}
	
	
	
	public String checklink(String link) throws IOException{
		HttpURLConnection connection=null ;
		try{
			URL url = new URL(link);
			connection= (HttpURLConnection)url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();
		}
		catch(Exception e){
			System.out.print(" "+e.getMessage()+" ");
			return "failed";
		}
		return connection.getResponseMessage();
	}
}
