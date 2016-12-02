package scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	protected WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		//driver = new ChromeDriver();
		this.driver = driver;
		wait = new WebDriverWait(this.driver, 10); 
	}

	protected boolean clickElement(WebElement element) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(element)).click();
			return true;
		}catch (Exception e) {
			return false;
		}
	}

	protected boolean sendKeys(WebElement element, String text) {
		try {	
			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver arg0)
				{
					return element.isEnabled();
				}
			});
			//wait.until(ExpectedConditions.visibilityOf(element)); no se hace
			element.clear();
			element.sendKeys(text);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// verificando que el tamano de la lista sea de tamano minimo
	protected boolean verifyListSize(List<WebElement> element, int num) {
		try {	
			return wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver arg0)
				{
					return element.size() > num;
				}
			});
		} catch (Exception e) {
			return false;
		}
	}
	
	
	protected WebElement findElement(By element) {	// presenceOfElement
		try {
			return wait.until(ExpectedConditions.presenceOfElementLocated(element));
		} catch (Exception e)	{
			return null;
		}
	}
	
	protected boolean waitForElementToBeVisible(WebElement element) {
		try {
			return wait.until(ExpectedConditions.visibilityOf(element)) != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	protected boolean verifyTextOnElement(WebElement element, String text) {
		try {
			waitForElementToBeVisible(element);
			// espero hasta que el elemento tenga el texto que yo necesito
			// si lo hago sin wait.until el mae pregunta sin esperar 
			return wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver arg0)
				{
					System.out.println(element.getText());
					return element.getText().contains(text);
				}
			});
			
		} catch (Exception e) {
			return false;
		}
	}

}
