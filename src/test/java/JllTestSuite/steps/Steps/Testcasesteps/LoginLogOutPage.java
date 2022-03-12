package JllTestSuite.steps.Steps.Testcasesteps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objectRepository.GetObj;
import utility.CommonMethods;
import utility.WebDriverFactory;
import utility.screenshotUtility;

	
	public class LoginLogOutPage extends GetObj {
		
		GetObj loginPfizer;
		 WebDriverFactory webDriverFactory;
		public static WebDriver driver;
		boolean present;
		String TestCaseID = PfizerTestCaseID.TCID;
		String ModuleName = PfizerTestCaseID.SheetName;
		

		
		
		
		@SuppressWarnings("static-access")
		public LoginLogOutPage(WebDriverFactory DriverFactory) throws Exception
		{
			super(DriverFactory);
			webDriverFactory = DriverFactory;
			this.driver = webDriverFactory.getWebDriver();
			
			
		}

		 

		 @Given("^open Browser and enter url$")
		    public void open_Browser_and_enter_url() throws IOException, Exception {
			 
			String url = getDataFromExcel(ModuleName, TestCaseID, "URL");
			System.out.println(url);
			
			driver.get(url);
			Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot(driver));
			
		}

			 
			 
			 @Then("^Click on the Country drop down$")
			    public void click_on_the_country_drop_down() throws Throwable {
				 element("Countrydropdown").click();
					Thread.sleep(2000);	
				 element("selectcountry").click();
			    }
			 
	
				    @When("^Accept the cookies$")
				    public void accept_the_cookies() throws Throwable {
					element("AcceptCookies").click();
				    }
				    

				    
			      
				    
				    }

				    

