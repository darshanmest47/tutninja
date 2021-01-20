package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ActionsClass;

public class Homepage {
	
	private WebDriver driver;
	public ActionsClass acts;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		acts = new ActionsClass(driver);
		
	}
	
	@FindBy(xpath="//a[text()='Desktops']")
	private WebElement desktops;
	
	@FindBy(xpath="//div[@class='dropdown-menu']/a[contains(text(),'Show All Desktops')]")
	private WebElement showall;
	
	@FindBy(xpath="//div[@class='dropdown-inner']/ul/li/a[contains(text(),'PC')]")
	private WebElement PC;
	
	@FindBy(xpath="//div[@class='dropdown-inner']/ul/li/a[contains(text(),'PC')]/parent::li/following-sibling::li/a[contains(text(),'Mac')]")
	private WebElement Mac;
	
	
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
	

}
