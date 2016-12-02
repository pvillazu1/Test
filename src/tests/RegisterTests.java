package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;
import scripts.BaseTest;

public class RegisterTests extends BaseTest {

	private WebDriver driver;
	//private String baseUrl;
	//private BasePage basepage;
	private RegisterPage registerp;
	

	  @BeforeTest
	  public void start() {
		  System.out.println("Start Execution");
	  }
	  
	  @BeforeClass(alwaysRun = true)
	  public void inProgress () {
	  	System.out.println("Executing class: RegisterTests");
	  }
	  
	  @BeforeMethod
	  public void setUp() throws Exception {
		System.out.println("Creating Driver");  
	    driver = createLocalDriver("chrome");
	    //baseUrl = "http://192.168.0.103:86/";
		driver.get("http://192.168.0.103:86/");
	    //basepage = new BasePage(driver);
//		registerp = new RegisterPage(driver);
		HomePage homepage = new HomePage(driver);
		homepage.verifyLoads();
		registerp = homepage.clickRegister();
	  }
	  
	  @Test
	  public void testTc11RegisterPageDisplayed() {
		  //hacer click en register con objeto homepage
		  Assert.assertTrue(registerp.verifyLoads());
	  }
	  
	  @Test
	  public void testTc12MandatoryFieldsMessages() {
		  registerp.verifyLoads();
		  registerp.clickSubmit();
		  Assert.assertTrue(registerp.verifyMandatoryMsg());	  
	  }
	  
	  @Test
	  public void testTc13UsernameAlreadyTaken() {
		  registerp.verifyLoads();
		  registerp.createUser("Pamela", "Villalobos", "pamela1@zoomer.io", "pvillazu", "BENQ2012!", "BENQ2012!", "something", "something too");
		  //registerp.clickSubmit();
		  Assert.assertTrue(registerp.userNameTakenMsg());
	  }
	  
	  @Test
	  public void testTc14ConfirmPasswordErrorMessage() {
		  registerp.verifyLoads();
		  registerp.createUser("Pamela", "Villalobos", "pamela1@zoomer.io", "pvillazu", "BENQ2012!", "BENQ2012", "something", "something too");
		  Assert.assertTrue(registerp.passwordNotMatching());
	  }
	  
	  @AfterMethod
	  public void deleteDriver() {
		  System.out.println("Deleting Driver");
		  driver.quit();
	  }
	  
	  @AfterClass
	  public void completeExecution() {
		  System.out.println("Completing execution class: RegisterTests");
	  }
	  
	  @AfterTest
	  public void finishingExecution() {
		  System.out.println("Completing Execution");
	  }

}
