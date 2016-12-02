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
import scripts.BaseTest;

public class LogInTests extends BaseTest {
	  private WebDriver driver;
//	  private String baseUrl;
//	  BasePage basepage;
	  private LogInPage login;
	  
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
		//login = new LogInPage(driver);
				
		HomePage homepage = new HomePage(driver);
//		login = new LogInPage(driver);
		homepage.verifyLoads();
		// se almacena el click de homepage de una en login para evitar tener que crear el objeto (ahorro de espacio)
		login = homepage.clickLogIn();
		//login = new HomePage(driver).clickLogIn();
	  }

	  @Test
	  public void testTc15LogIn() {
		  //hacer click en log in con objeto homepage
		  Assert.assertTrue(login.verifyLoads());
	 }
		  
	  @Test
	  public void testTc16Usercanlogin() {
		  //qwerty
		  Assert.assertTrue(login.logIn("pvillazu", "PpVv135#").verifyLoads());
	  }
		  
	  @Test
	  public void testTc17Invalidlogin() {
		  login.verifyLoads();
		  login.logIn("pvillazu", "123456");
		  Assert.assertTrue(login.verifyErrorMsg());
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
