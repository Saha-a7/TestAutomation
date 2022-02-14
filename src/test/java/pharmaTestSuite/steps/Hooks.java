package pharmaTestSuite.steps;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.*;
import cucumber.runtime.FeatureBuilder;
import cucumber.runtime.StepDefinition;
import cucumber.runtime.StepDefinitionMatch;
import utility.CommonMethods;
import utility.EmailUtility;
import utility.Report;
import utility.WebDriverFactory;
import utility.screenshotUtility;

@SuppressWarnings("unused")
public class Hooks {
	
	WebDriverFactory webDriverFactory;
	public static WebDriver driver;
	boolean present;
	public Hooks(WebDriverFactory DriverFactory) throws IllegalAccessException
	{
		webDriverFactory = DriverFactory;
		driver = webDriverFactory.getWebDriver();
		CommonMethods.driver = driver;
	}

	@Before()
	public void beforeScenarioExtentReportEntry(Scenario scenario) {
		
		driver.manage().deleteAllCookies();
		System.out.println("Hook executed");
		CommonMethods.CopyLogsInArchive(); 
		System.out.println("testauto");
/*		if (scenario.getName().equals("Pfizer - Verify case details")) 
		{
			
		}
		else
		{
			Reporter.assignAuthor("Ashirbad");
		}*/
		CommonMethods.AuthorsName();
		
		
	}
	
	@SuppressWarnings("static-access")
	@After(order = 1)
	public void afterScenarioExtentReportEntry(Scenario scenario) throws Throwable {
		
		System.out.println("Hook After method started");
		try {
			if (scenario.getStatus().toString().toLowerCase() == "failed")
			{
				//screenshotUtility.getScreenshot(driver);
				Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot(driver));
			}
			
		} catch (UnhandledAlertException e) {
			System.out.println("Browser closed ++123"+e);
			
			CommonMethods.acceptAlert();

		}
		finally {
			
			Report.extentEnvironmentInfo();  
			System.out.println("SCENARIO: "+scenario.getName()+" - "+scenario.getStatus());
	//	CommonMethods.closeBrowser(driver);
	//		CommonMethods.closeWebDriverProcess();
		}
	


	
		
	}
	
	
	

	
	
	
	
	
	
	
}
