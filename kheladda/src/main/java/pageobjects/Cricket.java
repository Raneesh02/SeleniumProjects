package pageobjects;

import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import resources.Base;

public class Cricket {
	public WebElement getCricketFilter(String filter){
		List<WebElement> filterlist=Base.driver.findElements(By.xpath("//span[@class='bf-cell bf-c-2 bf-cascade-0']"));
		Iterator<WebElement> it=filterlist.iterator();
		WebElement filterItem;
		while(it.hasNext()){
			filterItem=it.next();
			if(filterItem.getText().equals(filter)){
			return filterItem;
			}
		}
		return null;
	}
	public WebElement getfilterApplybtn(){
	return Base.driver.findElement(By.xpath("//input[@value='Apply']"));	
	}

	public List<WebElement> getProductDesclist(){
		return Base.driver.findElements(By.xpath("//div[@class='col-des']/div/h2[@class='product-name']/a"));
		
	}
	
	public List<WebElement> getPageNav(){
		return Base.driver.findElements(By.xpath("//ul[@class='pagination']/li/a"));
	}
	
	public int getTotalPages(){
		int maxpageno=0;
		List<WebElement> navlist=getPageNav();
		Iterator<WebElement> webelem=navlist.iterator();
		int text = 0;
		while(webelem.hasNext()){
			try{
			text=Integer.parseInt(webelem.next().getText());
			}
			catch(NumberFormatException e){
		//do nothing
			}
			if(text>maxpageno)
			{
				maxpageno=text;
			}
			
		}
		return maxpageno;		
	}
	
	public void gotoPage(int i){
		List<WebElement> navlist=getPageNav();
		Iterator<WebElement> webelem=navlist.iterator();
		String text = "";
		WebElement itr;
		while(webelem.hasNext()){
			itr=webelem.next();
		if(itr.getText().equals(""+i+"")){
			itr.click();
			break;
		}
		}
		
	}
}
