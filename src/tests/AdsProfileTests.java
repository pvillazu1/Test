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
import pages.LogInPage;
import pages.NavigationPage;
import scripts.BaseTest;

public class AdsProfileTests extends BaseTest {

	private WebDriver driver;
	//private String baseUrl;
	//private BasePage basepage;
	private LogInPage login;
	private HomePage homepage;
	private NavigationPage navpage;

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
	    driver.get("http://192.168.0.103:86/");
		homepage = new HomePage(driver);
		navpage = new NavigationPage(driver);
		//homepage.verifyLoads();
		//homepage.clickLogIn().logIn("pvillazu", "PpVv135#");
		//login = homepage.clickRegister();
	  }
	  
	  @Test
	  public void testTc09AdsProfilePageDisplayedCorrectly() {
		  homepage.clickLogIn().logIn("pvillazu", "PpVv135#").verifyLoads();
		  Assert.assertTrue(navpage.clickAdsProfile().verifyLoads()); 
	  }	  
	  
	  @Test
	  public void testTc10LogInPageDisplayedWhenUserNotLogged() {
		  navpage.clickAdsProfile();
		  login = new LogInPage(driver);
		  Assert.assertTrue(login.verifyLoads());
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


