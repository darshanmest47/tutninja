package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ActionsClass;

public class Loginpage {
	
	private WebDriver driver;
	private ActionsClass acts;
	public WebDriverWait wt;
	
	
	
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		acts = new ActionsClass(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwd;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement login;
	
	@FindBy(xpath="//div[contains(text(),' Warning: No match for E-Mail Address and/or Password.')]")
	private WebElement warning;
	
	
	public void enterUsername(String un) {
		acts.enterData(email, un);
	}
	
	public void enterPassword(String pwd) {
		acts.enterData(passwd, pwd);
	}
	
	public void clickSubmit() {
		acts.clcikElement(login);
	}
	
	public boolean warnDisp() {
		wt = new WebDriverWait(driver,30);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),' Warning: No match for E-Mail Address and/or Password.')]")));
				
		return warning.isDisplayed();
	}

}
