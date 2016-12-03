package scripts;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseTest {
	public WebDriver createLocalDriver(String browserType) {

//comment added to push :v
//comment added in my home :v
		//comment added from eclipse!
		
		WebDriver specifiedDriver;
		if (browserType == "chrome") {
			specifiedDriver = new ChromeDriver();
		} else {
			specifiedDriver = new FirefoxDriver();
		}
		return specifiedDriver;
	}
	
	public WebDriver createRemoteDriver() {
		try {
		WebDriver driver;
		//String nodeURL = "http://localhost:4444/wd/hub/*";
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setBrowserName("chrome");
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		return driver; 
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
