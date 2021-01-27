package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionsClass;

public class Homepage {
	
	private WebDriver driver;
	public ActionsClass acts;
	public WebDriverWait wt;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		acts = new ActionsClass(driver);
		wt= new WebDriverWait(driver, 50);
		
	}
	
	@FindBy(xpath="//a[text()='Desktops']")
	private WebElement desktops;
	
	@FindBy(xpath="//div[@class='dropdown-menu']/a[contains(text(),'Show All Desktops')]")
	private WebElement showall;
	
	@FindBy(xpath="//div[@class='dropdown-inner']/ul/li/a[contains(text(),'PC')]")
	private WebElement PC;
	
	@FindBy(xpath="//div[@class='dropdown-inner']/ul/li/a[contains(text(),'PC')]/parent::li/following-sibling::li/a[contains(text(),'Mac')]")
	private WebElement Mac;
	
	// 27-01-2021 @Darshanmesta
	
	@FindBy(xpath="//div[@id='cart']/button[@data-toggle='dropdown']")
	private WebElement cart;
	
	@FindBy(xpath="//button[@title='Remove']")
	private WebElement Remove;
	
	@FindBy(xpath="//p[text()='Your shopping cart is empty!']")
	private WebElement empty;
	
	// 27-01-2021 @Darshanmesta
	
	
	public void clickDesktops() throws InterruptedException {
		acts.mouseHoverAndClick(desktops);
	}
	
	public boolean pcDsiplayed() {
		return acts.elementDisplayed(PC);
	}
	
	public boolean macDsiplayed() {
		return acts.elementDisplayed(Mac);
	}
	
	public void clickShowAll() {
		acts.clcikElement(showall);
	}
	
	
	
//27-01-2021 @Darshan Mesta	
	
	public void clickCart() {
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='cart']/button[@data-toggle='dropdown']")));
		acts.clcikElement(cart);
	}
	
	
	public void clickRemove() {
		
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Remove']")));
			acts.clcikElement(Remove);
		
		
	
	}
	
	public boolean itemRemoved() {
		return empty.isDisplayed();
	}
	
	
	//27-01-2021 @Darshan Mesta	
	

}
