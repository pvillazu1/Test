package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import scripts.BasePage;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	NavigationPage navpage = new NavigationPage(driver);

	@FindBy(xpath="//*[contains(@id,'ctl00_LoginView_LoginLink')]")
	private WebElement loginLink;
	
	@FindBy(xpath="//a[contains(@id,'ctl00_LoginView_RegisterLink')]")
	private WebElement registerLink;
	
	@FindBy(xpath="//*[contains(text(),'Browse Categories')]")
	private WebElement title;
	
	@FindBy(xpath="//a[contains(@id,'CategoryButton')]")
	private List<WebElement> allcategories;
	
	@FindBy(xpath="//span[@id='ctl00_LoginView_MemberName']")
	private WebElement username;
	
//	@FindBy(xpath="//a[contains(@id,'TopMenuRepeater')]")
//	private List<WebElement> navigationMenu;
//	
	@FindBy(xpath="//span[contains(text(),'Home')]")
	private WebElement home;
//	
//	@FindBy(xpath="//span[contains(text(),'Post an Ad')]")
//	private WebElement postAnAd;
//	
//	@FindBy(xpath="//span[contains(text(),'My Ads & Profile')]")
//	private WebElement adsProfile;
	
	@FindBy(xpath="//a[contains(text(),'Antiques & Collectibles')]")
	private WebElement atqCollect;
	
	@FindBy(xpath="//a[contains(text(),'Arts & Crafts')]")
	private WebElement artsCrafts;
	
	@FindBy(xpath="//a[contains(text(),'Auto')]")
	private WebElement auto;
	
	public boolean verifyLoads() {
		
		//Comentario STAGE 7 = como se creo navigationPage, se instancia (mediante la creacion de navpage) y se
		// verifica que el LOAD del menu completo mediante el VERIFY LOADS propio de NavigationPage (navpage.verifyLoads())
		
		// STAGES ANTERIORES: verificando que el tamano de la lista sea el tamano indicado 
//		if (verifyListSize(navigationMenu, 3)) {
//			
//			boolean sm = true;
//			for(int index=0; index < navigationMenu.size() && sm == true; ++index) {	
//				sm = waitForElementToBeVisible(navigationMenu.get(index));
//			}
//			
//		//return waitForElementToBeVisible(title) && sm;	
//		
//		}
//		
//		return false;
		  return waitForElementToBeVisible(title) && navpage.verifyLoads();

	}
	
	public boolean verifyUsr(String user) {
		return verifyTextOnElement(username, user); 
	}
	
//	public boolean navigateOnMenu() { //TODO Trabajar en stage 7
//		boolean option = true;
//		for(int index=0; index < navigationMenu.size(); ++index) {	
//			option = clickElement(navigationMenu.get(index));
//		}
//		
//		return option;
//		
//	}
	
	public RegisterPage clickRegister() {
		clickElement(registerLink);
		return new RegisterPage(driver);
	}
	// cuando le doy click a login me retorna un nuevo LogInPage (se carga la pagina log in)
	public LogInPage clickLogIn() {
		if (clickElement(loginLink)) {
			return new LogInPage(driver);
		} 
		return null; 
	}
	
	public HomePage clickHome() {
		clickElement(home);
		return new HomePage(driver);
	}
	
	public BrowseCategoriesPage clickCategorie(String option) {
		//Darle click a varias opciones de una misma seccion para ahorrar codigo
		// se le pasa el parametro concatenado de la opcion (la opcion se le pasa a la hora del test)
		// ubicar en el test con: :D
		// cuando le da click a la opcion deseada, devuelve browsecategories page
		clickElement(findElement(By.xpath("//a[contains(text(),'" + option + "')]")));
		return new BrowseCategoriesPage(driver);
	}

	
//	public BrowseCategoriesPage clickAntCollec(WebElement option) {
//		clickElement(option);
//		return new BrowseCategoriesPage(driver);
//	}
//	
//	public BrowseCategoriesPage clickArtCraft() {
//		clickElement(artsCrafts);
//		return new BrowseCategoriesPage(driver);
//	}
//	
//	public BrowseCategoriesPage clickAuto() {
//		clickElement(auto);
//		return new BrowseCategoriesPage(driver);
//	}
	
	
//	public boolean navigateToHome() {
//		return clickElement(home);
//	}
//	
//	public boolean navigateToPost() {
//		return clickElement(postAnAd);
//	}
//	
//	public boolean navigateToProfile() {
//		return clickElement(adsProfile);
//	}
	
}
