package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import scripts.BasePage;

public class NavigationPage extends BasePage {
	public NavigationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'Home')]")
	private WebElement home;
	
	@FindBy(xpath="//span[contains(text(),'Post an Ad')]/..")
	private WebElement postAnAd;
	
	@FindBy(xpath="//span[contains(text(),'My Ads & Profile')]/..")
	private WebElement adsProfile;
	
	@FindBy(xpath="//h3[contains(text(),'Browse Categories')]")
	private WebElement browseCategories;
	
	public boolean verifyLoads() {
		return waitForElementToBeVisible(home) && waitForElementToBeVisible(postAnAd) && waitForElementToBeVisible(adsProfile);
	}
	
	public HomePage clickHome() {
		if (clickElement(home)) {
			return new HomePage(driver);
		} 
		return null; 
	}
	
	public PostAnAdPage clickPost() {
		if (clickElement(postAnAd)) {
			return new PostAnAdPage(driver);
		}
		return null;
	}
	
	public AdsAndProfilePage clickAdsProfile() {
		if(clickElement(adsProfile)) {
			return new AdsAndProfilePage(driver);
		}
		return null;
	}
}
