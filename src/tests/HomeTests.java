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
import scripts.BaseTest;

public class HomeTests extends BaseTest {
	private WebDriver driver;
	private HomePage homepage;
	//private NavigationPage navbar;

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
		
		// creating local chrome driver
		driver = createLocalDriver("chrome");
		driver.get("http://192.168.0.103:86/");
		
		// new home page object, verifies the correctly loading of the page
		homepage = new HomePage(driver);
		homepage.verifyLoads();
		
	  }
	  
	  @Test
	  public void testTc01HomePageDisplayed() {
		  Assert.assertTrue(homepage.verifyLoads());
	  }
	  
	  @Test
	  public void testTc02HomePageNavMenu() {
		  // navbar.clickHome retorna un objeto home por lo que se usa el .verifyLoads que si retorna un boolean
		  Assert.assertTrue(homepage.clickHome().verifyLoads());
	
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
