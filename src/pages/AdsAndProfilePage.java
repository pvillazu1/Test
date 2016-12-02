package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import scripts.BasePage;

public class AdsAndProfilePage extends BasePage {

	public AdsAndProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h2[contains(text(),'My Current Ads')]")
	private WebElement currentAds;
	
	@FindBy(xpath="//h2[contains(text(),'Go to...')]")
	private WebElement goTosec;

	public boolean verifyLoads() {
		return waitForElementToBeVisible(currentAds) && waitForElementToBeVisible(goTosec); 
	}
}