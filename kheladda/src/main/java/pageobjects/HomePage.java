package pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import resources.Base;

public class HomePage {
	public List<WebElement> getAlllinks(){
		return Base.driver.findElements(By.tagName("a"));
	}
	
	public WebElement getCricketCat(){
		return Base.driver.findElement(By.xpath("//a[@href='cricket']"));
	}
	
	public WebElement getCricketMenuOption(String menutext){
		List<WebElement> menu=Base.driver.findElements(By.xpath("//div[@class='parentMenu']/a/span"));
		Iterator<WebElement> it=menu.iterator();
		
		WebElement menuitem;
		while(it.hasNext()){
			menuitem=it.next();
			System.out.println(menuitem.getText());
			if(menuitem.getText().equals(menutext)){
				return menuitem;
			}
			
		}
		return null;
	}	
	
	public WebElement getSearchBox(){
		return Base.driver.findElement(By.id("text-search"));
	}
	
	public WebElement getSearchButton(){
		return Base.driver.findElement(By.id("btn-search-category"));
		
	}
}
