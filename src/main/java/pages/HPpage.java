package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionsClass;

public class HPpage {
	

	private WebDriver driver;
	public static ActionsClass acts;
	private int quan =2;
	private double amt = 100.00;
	public WebDriverWait wt;
	
	
	public HPpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		acts = new ActionsClass(driver);
		wt  = new WebDriverWait(driver, 30);
		
		
	}
	
	@FindBy(xpath="//input[@name='quantity']")
	private WebElement qty;
	
	@FindBy(id="button-cart")
	private WebElement cart;
	

	
	@FindBy(xpath="//div[contains(@class,'alert-success')]")
	private WebElement success;
	
	@FindBy(xpath="//button/span[@id='cart-total' and contains(text(),'200')]")
	private WebElement cartdisp;
	
	@FindBy(xpath="//li/a[@title='My Account']")
	private WebElement acc;
	
	@FindBy(xpath="//ul/li/a[text()='Logout']")
	private WebElement logout;
	
	
	
	public void clearAndEnterQty() throws InterruptedException {
		acts.clearValue(qty);
		Thread.sleep(3000);
		acts.enterData(qty, quan+"");
	}
	
	public void clickCart() {
		acts.clcikElement(cart);
	}
	
	public boolean successDisp() {
	wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-success') and contains(text(),'Success')]")));
	
	return acts.elementDisplayed(success);
		
	}
	
	public boolean userValdisp() {
		return acts.elementDisplayed(cartdisp);
	}
	
	
	public void clickAccount() {
		acts.clcikElement(acc);
	}
	
	public void clickLogout() {
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul/li/a[text()='Logout']")));
		acts.clcikElement(logout);
	}
	

	
	
	
	
	
	
	
	

}
