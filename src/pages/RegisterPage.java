package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import scripts.BasePage;

public class RegisterPage extends BasePage {
	public RegisterPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[contains(text(),'Registration')]")
	private WebElement registerTitle;
	
	@FindBy(xpath="//input[contains(@id,'FirstName')]")
	private WebElement firstNameField;
	
	@FindBy(xpath="//input[contains(@id,'LastName')]")
	private WebElement lastNameField;
	
	@FindBy(xpath="//input[contains(@id,'Email')]")
	private WebElement emailField;
	
	@FindBy(xpath="//input[contains(@id,'UserName')]")
	private WebElement userNameField;
	
	@FindBy(xpath="//input[@id='ctl00_Main_CreateUserWizardControl_CreateUserStepContainer_Password']")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[contains(@id,'ConfirmPassword')]")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//input[contains(@id,'Question')]")
	private WebElement securityQuestionField;
	
	@FindBy(xpath="//input[contains(@id,'Answer')]")
	private WebElement securityAnswerField;
	
	@FindBy(xpath="//input[contains(@id,'ctl00_Main_CreateUserWizardControl___CustomNav0_StepNextButtonButton')]")
	private WebElement submitBtn;
	
	@FindBy(xpath="//input[contains(@id,'CreateUserStepContainer')]")
	private List<WebElement> registerInputs;
	
	@FindBy(xpath="//span[contains(text(),'is required')]")
	private List<WebElement> requiredMsg;
	
	@FindBy(xpath="//span[contains(text(),'User name already exists. Please enter a different user name.')]")
	private WebElement usernameTakenMsg;
	
	@FindBy(xpath="//span[contains(text(),'The password and confirmation password must match.')]")
	private WebElement passwordMustMatchMsg;
	
	@FindBy(xpath="//*[contains(text(),'Continue to Homepage')]")
	private WebElement continueToHpMsg;
	
	// Verifies that Register Title, submit button and all the fields are displayed on Register Page
	public boolean verifyLoads() {
		
		if (verifyListSize(registerInputs, 3)) {
			
			boolean sm = true;
			for(int index=0; index < registerInputs.size() && sm == true; ++index) {	
				sm = waitForElementToBeVisible(registerInputs.get(index));
			}
			
			return waitForElementToBeVisible(registerTitle) && waitForElementToBeVisible(submitBtn) && sm;	
		
		}
		
		return false;
	}
		
	// Verify all the mandatory messages are displayed after a submit with errors
	public boolean verifyMandatoryMsg() {
		
		if(verifyListSize(registerInputs, 3)) {
			
			boolean lr = true;
			for(int index=0; index < registerInputs.size() && lr == true; ++index) {	
				lr = waitForElementToBeVisible(registerInputs.get(index));
			}
		
		return lr;
		
		}
		
		return false;
	}
	
	// Click on submit button
	public boolean clickSubmit() {
		return clickElement(submitBtn);
	}
	
	// Creating an user
	public boolean createUser(String firstName, String lastName, String email, String username, String password, String confirmPassword, String securityQuestion, String securityAnswer ) {
		return sendKeys(firstNameField, firstName) && sendKeys(lastNameField, lastName) && sendKeys(emailField, email) && sendKeys(userNameField, username) &&
		sendKeys(passwordField, password) && sendKeys(confirmPasswordField, confirmPassword) && sendKeys(securityQuestionField, securityQuestion)
		&& sendKeys(securityAnswerField, securityAnswer) && clickSubmit();
		//return waitForElementToBeVisible(continueToHpMsg);
		
	}
	
	// verifying error message is displayed if username is already taken 
	public boolean userNameTakenMsg() {
		return waitForElementToBeVisible(usernameTakenMsg);
	}
	
	// verifying error message is displayed if password is not matching
	public boolean passwordNotMatching() {
		return waitForElementToBeVisible(passwordMustMatchMsg);
	
	}
	
}
