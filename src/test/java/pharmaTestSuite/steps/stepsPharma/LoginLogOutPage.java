package pharmaTestSuite.steps.stepsPharma;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.vimalselvam.cucumber.listener.Reporter;

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

			@When("^Enter username and password$")
			public void Enter_username_and_password() throws Throwable {

				element("pfizerUserIDTextbox").sendKeys(getDataFromExcel(ModuleName,TestCaseID, "UserName"));
				element("PasswordTxtbx").sendKeys(getDataFromExcel(ModuleName, TestCaseID, "Password"));
				
				Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot(driver));
				
				
			}
			 @When("^Accept the cookies$")
			    public void accept_the_cookies() throws Throwable {
					element("AcceptCookies").click();
			    }
			 
			 @Then("^Click on the Country drop down$")
			    public void click_on_the_country_drop_down() throws Throwable {
				 element("Countrydropdown").click();
					Thread.sleep(2000);	
				 element("selectcountry").click();
			    }
			 
			

			@When("^Click On Login Button$")
			public void Click_On_Login_Button() throws Throwable {
				
				CommonMethods.ScrolDownToTheObject(element("loginButton"));
				element("loginButton").click();
				System.out.println("Click On Login button");
				
			}
			
			
				
				@Then("^Then Logout from the PFIZER$")
				public void then_Logout_from_the_PFIZER() throws Throwable {
					
					driver.switchTo().defaultContent();
					
					Thread.sleep(1000);	
					element("UserIcon").click();
					Thread.sleep(1000);	
					element("LogOutButton").click();
					System.out.println("Logged Out From Pfizer");
					
				}
				
				
			    @Then("^Close All the All Tabs$")
			    public void close_all_the_all_tabs() throws Throwable {
					driver.switchTo().defaultContent();
					List<WebElement> DropDown = driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']/li[@role='presentation']"));
					
					for (int i =0;i<DropDown.size();i++ ) {
						WebElement CloseButton = driver.findElement(By.xpath("(//button[contains(@title,'Close')])[1]"));
						CloseButton.click();
						
					}
			    }
				
				
				
				@Given("^open Browser and enter portal url$")
				public void open_Browser_and_enter_portal_url() throws Throwable {
				    
					String portalurl = getDataFromExcel(ModuleName, TestCaseID, "PortalURL");
					System.out.println(portalurl);
					
					driver.get(portalurl);
					Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot(driver));
					//Thread.sleep(10000);
				    
				}

				@When("^Enter portal username and password$")
				public void enter_portal_username_and_password() throws Throwable {
					
					Thread.sleep(2000);
					System.out.println("size of frame" +driver.findElements(By.tagName("iframe")).size());
					driver.switchTo().frame(0);
					element("portalUserIDTextbox").click();
					element("portalPasswordTxtbx").click();
					element("portalUserIDTextbox").sendKeys(getDataFromExcel(ModuleName,TestCaseID, "PortalUserName"));
					element("portalPasswordTxtbx").sendKeys(getDataFromExcel(ModuleName, TestCaseID, "PortalPassword"));					
					Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot(driver));	
					

				    
				}

				@When("^Click On portal Login Button$")
				public void click_On_portal_Login_Button() throws Throwable {
					
					element("portalloginButton").click();
					System.out.println("Click On Login button");
				//	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
/*					Thread.sleep(2000);
					try {
						
						element("RemindMeLaterLink").click();
					} catch (Exception e) {
	                       
					}		*/
					
				    
				}	
				
				
				@Then("^Login to CRM using valid credentials$")
				public void login_to_CRM_using_valid_credentials() throws Throwable {
				    
					open_Browser_and_enter_url();
					Enter_username_and_password();
					Click_On_Login_Button();
					
				}
				
				@Then("^Login to CRM using valid admin credentials$")
				public void login_to_CRM_using_valid_admin_credentials() throws Throwable {
				    
					open_Browser_and_enter_url();
										
					element("pfizerUserIDTextbox").sendKeys(getDataFromExcel(ModuleName,TestCaseID, "AdminUserName"));
					element("PasswordTxtbx").sendKeys(getDataFromExcel(ModuleName, TestCaseID, "AdminPassword"));
					Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot(driver));
					Thread.sleep(5000);
					Click_On_Login_Button();
					
				}
				
				@Then("^Logout from Portal$")
				public void logout_from_portal() throws Throwable {
					
					driver.switchTo().defaultContent();
					
					Thread.sleep(1000);	

					JavascriptExecutor js = (JavascriptExecutor) driver; 
 
					js.executeScript("arguments[0].click();", element("portallogoutButton"));
						
					System.out.println("Logged Out From Portal");
					
				}				
				
				@Then("^Login to CRM using valid Agent credentials$")
				 public void Login_to_CRM_using_valid_Agent_credentials() throws Throwable {
					 
					 element("pfizerUserIDTextbox").sendKeys(getDataFromExcel(ModuleName,TestCaseID, "AgentUserName"));
						Reporter.addStepLog("Username : "+getDataFromExcel(ModuleName,TestCaseID, "AgentUserName"));
						
						element("PasswordTxtbx").sendKeys(getDataFromExcel(ModuleName, TestCaseID, "AgentPassword"));
						
						Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot(driver));
				 }
				
				@When("^Enter username and password of Pharmacist Admin User Name and Password$")
                public void Enter_username_and_password_of_Pharmacist_Admin_User_Name_and_Password() throws Throwable {

                       element("pfizerUserIDTextbox").sendKeys(getDataFromExcel(ModuleName,TestCaseID, "Pharmacist Admin User Name"));
                       element("PasswordTxtbx").sendKeys(getDataFromExcel(ModuleName, TestCaseID, "Pharmacist Admin Password"));
                       Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot(driver));
                       
                       
                }

				
}
