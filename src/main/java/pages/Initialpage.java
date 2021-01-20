package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionsClass;

public class Initialpage {
	private WebDriver driver;
	private ActionsClass acts;
	private boolean flag= false;
	WebDriverWait wt;
	
	public Initialpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
 @FindBy(xpath = "//li/a[@title='My Account']")
 private WebElement acc;
 
 @FindBy(xpath = "//ul[contains(@class,'dropdown-menu dropdown-menu-right')]")
 private WebElement ullist;
 
 @FindBy(xpath="//ul[contains(@class,'dropdown-menu dropdown-menu-right')]/li/a[text()='Login']")
 private WebElement login;
	
	public String dispTitle() {
	
		return driver.getTitle();
	}
 
 
 public void hoverMouse() throws InterruptedException {
	acts = new ActionsClass(driver);
	
	acts.mouseHoverAndClick(acc);
 }
 
 public boolean checkULList() {
	wt = new WebDriverWait(driver, 30);
	wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class,'dropdown-menu dropdown-menu-right')]")));
	return ullist.isDisplayed();
 }
 
 public void clickLogin() {
	 acts.clcikElement(login);
 }
	
	
	

}
