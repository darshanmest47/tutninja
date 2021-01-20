package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {
	
	private WebDriver driver;
	private Actions acts;
	
	public ActionsClass(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void mouseHoverAndClick(WebElement ele) throws InterruptedException {
		acts = new Actions(driver);
		acts.moveToElement(ele).build().perform();
		Thread.sleep(5000);
		acts.moveToElement(ele).click().build().perform();
		
		
	}
	
	public void clcikElement(WebElement ele) {
		 ele.click();
	}
	
	public void enterData(WebElement ele,String data) {
		ele.sendKeys(data);
	}
	
	public String returnPageTitle() {
		return driver.getTitle();
	}
	
	public boolean elementDisplayed(WebElement ele) {
		return ele.isDisplayed();
	}
	
	public void clearValue(WebElement ele) {
		ele.clear();
	}

}
