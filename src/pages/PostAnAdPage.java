package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import scripts.BasePage;

public class PostAnAdPage extends BasePage {

	public PostAnAdPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h3[contains(text(),'Registration')]")
	private WebElement registerTitle;
	
	@FindBy(xpath="//h2[contains(text(),'Post an Ad: Category Selection')]")
	private WebElement categorieSelect;
	
	
	public boolean verifyLoads() {
		return waitForElementToBeVisible(categorieSelect);
	}
}
