package utility;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import utility.ConfigFile;

import com.paulhammant.ngwebdriver.*;

@SuppressWarnings("unused")
public class WebDriverFactory {
	
	public static WebDriver driver;
	
	
	public static  String browserType = ConfigFile.getConfigValue("Browser").toString();
			
			//"chrome";

	//public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();
	
	public WebDriverFactory() throws IllegalAccessException
	{
		setWebDriver();
		
	}
		public  static WebDriver create(String type) throws IllegalAccessException
		{
			
			switch(type.toLowerCase()) {
			case "chrome":
				
				
			//	String exePath = System.getProperty("user.dir")+"\\src\\test\\resources\\WebDrivers\\chromedriver.exe";
				
				System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");

				ChromeOptions options = new ChromeOptions();
				
				Map<String,Object> pref = new HashMap<String, Object>();
				pref.put("profile.exit_type", "none");
				pref.put("profile.exited_cleanly", Boolean.valueOf("True"));
				options.setExperimentalOption("prefs", pref);
				options.addArguments("--disable-notifications");
				options.addArguments("disable-infobars");
				
				
				options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
				options.setCapability("exit_type", "none");		
				options.addArguments("--disable-extensions");
				options.setAcceptInsecureCerts(true);
				
			
				//options.addArguments("user-data-dir=C:/Users/701631/AppData/Local/Google/Chrome/User Data/Profile 10");
				
				
				//options.addArguments("headless","window-size=1400,800"); //to execute in headless mode
				options.addArguments("--start-maximized");
						
				

				driver = new ChromeDriver(options);
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			 	//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				break;
				
			case "grid":
				DesiredCapabilities d = DesiredCapabilities.chrome();
				break;
				
			default:
				throw new IllegalAccessException();
			}
			return driver;
			
		}
		
		public  WebDriver setWebDriver() throws IllegalAccessException {
			
			
			//WebDriverFactory.browserType="Chrome";
		//	WebDriver driver = create("Chrome");
		//	System.out.println("Browser Value from Config File"+ConfigFile.ConfigValue("Browser"));
			WebDriver driver = create(WebDriverFactory.browserType);
					//create(ConfigFile.ConfigValue("Browser").toString());
					
			//dr.set(driver);
			return driver;
			
			
			
		}
		public   WebDriver getWebDriver() throws IllegalAccessException{
			//return dr.get();
			return driver;
		}
		
	
		
		
}
