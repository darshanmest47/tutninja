package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ActionsClass;

public class Loggedoutpage {
	
	private WebDriver driver;
	public ActionsClass acts;
	
	public Loggedoutpage(WebDriver driver) {
		this.driver = driver;
		acts = new ActionsClass(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//h1[text()='Account Logout']")
	private WebElement logmsg;

	
	public boolean loggedMSGDisp() {
		return acts.elementDisplayed(logmsg);
	}
}
