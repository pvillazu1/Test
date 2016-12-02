package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import scripts.BasePage;

public class LogInPage extends BasePage {
	public LogInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	NavigationPage navpage = new NavigationPage(driver);
	
	@FindBy(xpath="//*[contains(@name,'ctl00$Main$LoginConrol$UserName')]")
	private WebElement usernameField;
	
	@FindBy(xpath="//*[contains(@name,'ctl00$Main$LoginConrol$Password')]")
	private WebElement passwordField;
	
	@FindBy(xpath="//*[contains(@name,'ctl00$Main$LoginConrol$LoginButton')]")
	private WebElement logInBtn; 
	
	@FindBy(xpath="//*[contains(text(),'Your login attempt was not successful. Please try again.')]")
	private WebElement errorMessageField; 
	
//	@FindBy(xpath="//span[contains(text(),'Home')]")
//	private WebElement home;
//	
//	@FindBy(xpath="//span[contains(text(),'Post an Ad')]")
//	private WebElement postAnAd;
//	
//	@FindBy(xpath="//span[contains(text(),'My Ads & Profile')]")
//	private WebElement adsProfile;
		
	public boolean verifyLoads() {
		return waitForElementToBeVisible(usernameField) && waitForElementToBeVisible(logInBtn) && navpage.verifyLoads();
	}
	
	// TODO if 
	public HomePage logIn(String user, String pass) {	
		if (sendKeys(usernameField, user) && sendKeys(passwordField, pass) && clickElement(logInBtn)) {
			return new HomePage(driver); 
		}
		return null; 	
	}
	
	public boolean verifyErrorMsg() {
		//errorMsg = "Your login attempt was not successful. Please try again.";
		return waitForElementToBeVisible(errorMessageField);
		
	}
	
}
