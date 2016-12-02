package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import scripts.BasePage;

public class BrowseCategoriesPage extends BasePage {
	public BrowseCategoriesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[contains(@id,'ctl00_Main_SearchButton')]")
	private WebElement searchBtn;
	
	@FindBy(xpath="//*[contains(text(),'Continue Browsing Subcategories')]")
	private WebElement continueBrowsingTtl;

	@FindBy(xpath="//select[contains(@id,'ctl00_Main_CategoryDropDown_CategoryList')]")
	private WebElement searchCategorieDropdown;
	
	@FindBy(xpath="//option[@selected]")
	private WebElement selectedOption;
	
	@FindBy(xpath="//select[contains(@id,'ctl00_Main_CategoryDropDown_CategoryList')]")
	private WebElement categorieDp;
	
	public boolean verifyLoads() {
		return waitForElementToBeVisible(searchBtn) && waitForElementToBeVisible(continueBrowsingTtl);
	}
	
	public boolean verifySelectedOption(String option) {
		return verifyTextOnElement(selectedOption, option);
	}
	
}
