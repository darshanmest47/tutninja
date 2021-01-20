package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ActionsClass;

public class Desktoppage {
	private WebDriver driver;
	public ActionsClass acts;
	
	public Desktoppage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		acts = new ActionsClass(driver);
		
		
	}
	
	@FindBy(xpath="//h4/a[text()='HP LP3065']")
	private WebElement HP_LP3065;
	
	@FindBy(xpath="//h4/a[text()='HP LP3065']/parent::h4/parent::div/following-sibling::div/button/i[contains(@class,'fa-shopping-cart')]/parent::button")
	private WebElement shoppingbutt;
	
	public boolean hpDisplayed() {
		return acts.elementDisplayed(HP_LP3065);
	}
	
	public void shoppingButtonClick() {
		acts.clcikElement(shoppingbutt);
	}
	
	

}
