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

import pages.BrowseCategoriesPage;
import pages.HomePage;
import scripts.BaseTest;

public class BrowseCTests extends BaseTest {
	private WebDriver driver;
	//private HomePage homepage;
	private BrowseCategoriesPage browsecategories;
	private HomePage homepage;
	
	  @BeforeTest
	  public void start() {
		  System.out.println("Start Execution");
	  }
	  
	  @BeforeClass(alwaysRun = true)
	  public void inProgress () {
	  	System.out.println("Executing class: BrowseCategories");
	  }
	  
	  @BeforeMethod
	  public void setUp() throws Exception {
		System.out.println("Creating Driver");  
	    driver = createLocalDriver("chrome");
		driver.get("http://192.168.0.103:86/");
		// duda aclarada con esta variable y la variable private HomePage homepage: 
		// la de arriba es GLOBAL mientras que la que sigue es meramente para este metodo
		// se utiliza para poder construir el driver que vamos a utilizar (llamese el sitio)
		// la de arriba es el objeto homepage de la clase HOMEPAGE del cual vamos a usar los metodos
		homepage = new HomePage(driver);
	  }
	  
	  @Test
	  public void testTc03searchViewAntiquesCollectibles() {
		  // :D browsecategories le da click a la opcion deseada
		  browsecategories = homepage.clickCategorie("Antiques & Collectibles");
		  Assert.assertTrue(browsecategories.verifySelectedOption("Antiques & Collectibles"));
	  }
	  
	  @Test
	  public void testTc04searchViewArtCrafts() {
		  browsecategories = homepage.clickCategorie("Arts & Crafts");
		  Assert.assertTrue(browsecategories.verifySelectedOption("Arts & Crafts"));
	  }
	  
	  @Test
	  public void testTc05searchViewAuto() {
		  browsecategories = homepage.clickCategorie("Auto");
		  Assert.assertTrue(browsecategories.verifySelectedOption("Auto"));
	  }
	  
	  @Test
	  public void testTc06searchViewAll() {
		  String array[] = {"Antiques & Collectibles", "Arts & Crafts", "Auto", "Electronics", "Garden", "Home", "Music"};
		  
		  for(int index=0; index < array.length; ++index) {	
			  String num = array[index];
			  browsecategories = homepage.clickCategorie(num);
			  Assert.assertTrue(browsecategories.verifySelectedOption(num));
			  driver.navigate().back();
			}				  
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
