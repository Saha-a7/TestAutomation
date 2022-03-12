package JllTestSuite.steps.Steps.Testcasesteps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

	
	public class Workday extends GetObj
	{
		
		GetObj loginPfizer;
		 WebDriverFactory webDriverFactory;
		public static WebDriver driver;
		boolean present;
		String TestCaseID = PfizerTestCaseID.TCID;
		String ModuleName = PfizerTestCaseID.SheetName;
		

		
		
		
		@SuppressWarnings("static-access")
		public Workday(WebDriverFactory DriverFactory) throws Exception
		{
			super(DriverFactory);
			webDriverFactory = DriverFactory;
			this.driver = webDriverFactory.getWebDriver();
			
			
		}
		
	
		@Then("^Click on Career nav item$")
	    public void click_on_career_nav_item() throws Throwable {
	    	 element( "Careers").click();
	    	 JavascriptExecutor js = (JavascriptExecutor) driver;
		    	js.executeScript("window.scrollBy(0,250)", "");
	    	String Actual_Url=driver.getCurrentUrl();
	    		String	 Expected_Url="https://stage.us.jll.com/en/careers";
	    	 Assert.assertEquals(Actual_Url,Expected_Url);
	    }
	    
	    @Then("^Locate the HtmlForm component$")
	    public void locate_the_htmlform_component() throws Throwable {
	      Boolean b= element("HtmlForm").isDisplayed();
	      Boolean a=true;
	      Assert.assertEquals(b, a);
	    }
	    
	    @And("^Click on I am Looking for field$")
	    public void click_on_i_am_looking_for_field() throws Throwable {
	        element("JobKeyword").click();
	        String Keyword = getDataFromExcel(ModuleName, TestCaseID, "I am looking for");
	        element("JobKeyword").sendKeys(Keyword);
	        
	    }
	    
	    @And("^Validate Country dropdown is preset to users current site$")
	    public void validate_country_dropdown_is_preset_to_users_current_site() throws Throwable {
	    	
	    
	       String ActualPresetValue=element("Country").getText();
	      System.out.println(ActualPresetValue);
	      
	
	      
	      
	      String ExpectedPresetValue="United States of America";
	      Assert.assertEquals(ActualPresetValue,ExpectedPresetValue);
	      

	



element("Dropdown").click();
List<WebElement> a=ListElemnet("CountryList");
int b=a.size();
System.out.println(b);
for (int i = 0; i < a.size(); i++) {

System.out.println(a.get(i).getText());

}
element("India").click();


	    
	    
	   
	    	element("Search").click();
	    
	  
    
       
       Thread.sleep(2000);
      Set<String> Tabs=     driver.getWindowHandles();
      System.out.println(Tabs);
      for (String tab : Tabs) {
    	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      driver.switchTo().window(tab);
      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    String  url=driver.getCurrentUrl();
    System.out.println(url);
      
    if(url.contains("https://jll.wd1.myworkdayjobs.com/jllcareers"))
    {
    	System.out.println(element("India1").isDisplayed());
    }
      
     
      }
      
      
 
 
   

   
		  
     } }
		
		
		
	
	
	