package pharmaTestSuite.steps;


import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.management.OperationsException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.vimalselvam.cucumber.listener.Reporter;

import pharmaTestSuite.steps.stepsPharma.PfizerTestCaseID;
import utility.CommonMethods;
import utility.screenshotUtility;

public class ClassTest {
	 static int max=100;
	    public static void main(String[] args) throws Throwable {

			/*   Today   String exePath = System.getProperty("user.dir")+"\\src\\test\\resources\\WebDrivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("user-data-dir=C:/Users/52006894/AppData/Local/Google/Chrome/User Data/Default");
	        options.addArguments("--start-maximized");

			
			WebDriver driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			

			
	        String url ="https://pfizerpas--pfizerqa.lightning.force.com/lightning/r/Application__c/a010t000005yiQGAAY/view"
;	        		
;
	        driver.get(url);
	        driver.findElement(By.id("username")).sendKeys("aniket.patil@conduent.com.pfizerqa");
	        driver.findElement(By.id("password")).sendKeys("Mar@1234");
	        
	        driver.findElement(By.id("Login")).click();*/
	        


/*WebElement select = driver.findElement(By.id("airlineid"));
WebElement option = select.get
String selectedValueInDropDown = option.getText();*/
	//		Select ListValues = new Select(driver.findElement(By.xpath("//select[contains(@id,'theForm:theGlobalSearch:fldPatient')]")));			 
Thread.sleep(15000);	
//driver.switchTo().frame(0);



//Alert alt =driver.switchTo().alert();
//alt.accept();

/*driver.findElement(By.xpath("//td[@class='dataCol ']/a/span")).click();


Thread.sleep(3000);
 String winHandleBefore = driver.getWindowHandle();
 
 for(String winHandle : driver.getWindowHandles()){
	 System.out.println(winHandle);
     driver.switchTo().window(winHandle);
 }
 driver.manage().window().maximize() ;*/
 //driver.switchTo().defaultContent();
 //driver.findElement(By.xpath("//div[@title='PAP Appeal']")).click();

 
 

   



/*               Select select = new Select(driver.findElement(By.xpath("//select[contains(@id,'theForm:theGlobalSearch:fldPatient')]"))); 
		       java.util.List<WebElement> options1 = select.getOptions(); 
		       String text = "Phone No";
		       
		       Boolean found = false;
		        for(WebElement item:options1) 
		        { 
		        	if (item.getText().equals(text)) {
						found = true;
						break;
					}else {
						found = false;
					}
		        }

				if (found) {
					System.out.println(text +" is displayed");
				}else {
					System.out.println(text +" is not displayed");
				}*/
		      
	        
/*	        int size = driver.findElements(By.tagName("iframe")).size();
	        
	        System.out.println(size);
	        driver.switchTo().frame(4);
	        
	        try {
	        	 Alert alert=driver.switchTo().alert();
	        	 alert.accept();
			} catch (Exception e) {
				 
			}
		      

	    	
	    	driver.findElement(By.xpath("(//input[@value='Remove'])[1]")).isEnabled();
	    	driver.findElement(By.xpath("//input[@value='Attach']")).isEnabled();*/
	        
/*			for (int i =0;i<8;i++ ) {
				try {
					System.out.println(i);
					System.out.println(100/0);
				} catch (Exception e) {
					System.out.println("Incatch");
				}*/
	    	
	        
	        
/*	        int size = driver.findElements(By.tagName("iframe")).size();
	        System.out.println(size);
	        
			for (int i =0;i<=size;++i ) {
				
				try {
					driver.switchTo().defaultContent();
					System.out.println("start" + i);
					driver.switchTo().frame(i);
					System.out.println("Enter inn frame " + i);
					
					 WebElement  ele1 = driver.findElement(By.xpath("//input[@value='Add Patient']"));
				//	WebElement  ele1 = driver.findElement(By.xpath("//h3[text()='Practitioner Information']"));
					  System.out.println(ele1.isDisplayed());
					  break;
				} catch (NoSuchElementException | NoSuchFrameException e) {
					System.out.println("InCatch  "+i);
		 		}
			
				if (ele1.) {
					driver.switchTo().frame(i);
					System.out.println(i+"Current Frame");
				}*/

			
String exePath = System.getProperty("user.dir")+"\\src\\test\\resources\\WebDrivers\\chromedriver.exe";
System.setProperty("webdriver.chrome.driver", exePath);

ChromeOptions options = new ChromeOptions();
options.addArguments("user-data-dir=C:/Users/52006894/AppData/Local/Google/Chrome/User Data/Default");
options.addArguments("--start-maximized");


WebDriver driver = new ChromeDriver(options);
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);



String url ="https://pfizerpas--pfizerqa.lightning.force.com/lightning/r/Application__c/a010t000005yiQGAAY/view"
;                                              

driver.get(url);
driver.findElement(By.id("username")).sendKeys("aniket.patil@conduent.com.pfizerqa");
driver.findElement(By.id("password")).sendKeys("Mar@1234");

driver.findElement(By.id("Login")).click();
/*                   try {               
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                driver.findElement(By.xpath("//a[text()='Remind Me Later']")).click();
                }
catch (NoSuchElementException   Ex ) {
                
                                try {
                                                
                                                Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot(driver), "Logged In Succesfully");
                                                System.out.println("Logged In Succesfully");
                                }catch (UnhandledAlertException e) {
                                                driver.switchTo().alert().accept();
                                } catch (NoSuchElementException e) {
                                                System.out.println("Enter The OTP");
                                                String OTPtoEnter = EmailUtility.GetOTP();
                                                driver.findElement(By.xpath("//label[text()='Verification Code']/following-sibling::div/input[@type='text']")).sendKeys(OTPtoEnter);
                                                driver.findElement(By.xpath("//input[@value='Verify'] ")).click();
                                                Reporter.addScreenCaptureFromPath(screenshotUtility.getScreenshot(driver), "Enter the OTP");
                                }catch (MailConnectException e) {
                                                System.out.println("Enter The OTP");
                                                String OTPtoEnter = EmailUtility.GetOTP();
                                                driver.findElement(By.xpath("//label[text()='Verification Code']/following-sibling::div/input[@type='text']")).sendKeys(OTPtoEnter);
                                                driver.findElement(By.xpath("//input[@value='Verify'] ")).click();
                                }

}catch (UnhandledAlertException e) {
                Thread.sleep(3000);
                driver.switchTo().alert().accept();
}              */





driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
List<WebElement> DropDown = driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']/li[@role='presentation']"));

for (int i =0;i<DropDown.size();i++ ) {
                WebElement CloseButton = driver.findElement(By.xpath("(//button[contains(@title,'Close')])[1]"));
                CloseButton.click();
                
}

/*                                           element("showNavigationMenuButton").click();

element("caseLink").click();
try {
                
                element("TableViewIcon");
                System.out.println("Opened in Split View");

} catch (NoSuchElementException e) {
                System.out.println("Opened in Table View");
                
                element("SplitViewIcon").click();
                
                System.out.println("It will oven in Table View");

                element("TableItemInSplitView").click();
                Thread.sleep(5000);
                
}

element("CasesListViewDropdown").click();
element("DocumentIntakeInListbox").click();
CommonMethods.PerformClickOnObject(element("FirstCaseNumberInDocumentIntake"));          
element("NewButton").click();



*/








/*                   int size = driver.findElements(By.tagName("iframe")).size();
System.out.println(size);

for (int i =0;i<=size;++i ) {
                
                try {
                                driver.switchTo().defaultContent();
                                System.out.println("start" + i);
                                driver.switchTo().frame(i);
                                System.out.println("Enter inn frame " + i);
                                
                                WebElement  ele1 = driver.findElement(By.xpath("//input[@value='Add Patient']"));
                //            WebElement  ele1 = driver.findElement(By.xpath("//h3[text()='Practitioner Information']"));
                                  System.out.println(ele1.isDisplayed());
                                  break;
                } catch (NoSuchElementException | NoSuchFrameException e) {
                                System.out.println("InCatch  "+i);
               }

                if (ele1.) {
                                driver.switchTo().frame(i);
                                System.out.println(i+"Current Frame");
                }*/



for(int i=0;i<=0;i++) {
driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();

driver.findElement(By.xpath("//a[@title='Cases']")).click();
try {
                
driver.findElement(By.xpath("//button[@title='Display as Table']"));
                System.out.println("Opened in Split View");

} catch (NoSuchElementException e) {
                System.out.println("Opened in Table View");
                
                driver.findElement(By.xpath("//button[@title='Display as Split View']")).click();
                
                System.out.println("It will oven in Table View");

                driver.findElement(By.xpath("//ul[@class='dropdown__list']//li[@title='Table']")).click();
                Thread.sleep(5000);
                
}
driver.findElement(By.xpath("//a[@title='Select List View']")).click();
driver.findElement(By.xpath("(//span[text()='Document Intake']/parent::a)[1]")).click();




driver.findElement(By.xpath("//a[@title='New' and @role='button']")).click();
Thread.sleep(3000);

driver.findElement(By.xpath ("//span[text()='Inbound Fax']")).click();


driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
Thread.sleep(3000);
/*         driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
driver.findElement(By.xpath("//span[text()='Client']/parent::label/following-sibling::div//input[@type='text']")).click();
driver.findElement(By.xpath("//span[text()='Client']/parent::label/following-sibling::div//input[@type='text']")).sendKeys("Pfizer");

try {
driver.findElement(By.xpath("//mark[@class='data-match']")).click();
} catch (Exception e) {
driver.findElement(By.xpath("//span[text()='Client']/parent::label/following-sibling::div//input[@type='text']")).click();
driver.findElement(By.xpath("//span[text()='Client']/parent::label/following-sibling::div//input[@type='text']")).clear();
driver.findElement(By.xpath("//span[text()='Client']/parent::label/following-sibling::div//input[@type='text']")).sendKeys("Pfizer");
driver.findElement(By.xpath("//mark[@class='data-match']")).click();
}



driver.findElement(By.xpath("//span[text()='Program']/parent::label/following-sibling::div//input[@type='text']")).click();
driver.findElement(By.xpath("//span[text()='Program']/parent::label/following-sibling::div//input[@type='text']")).sendKeys("RxPathways");

try {
driver.findElement(By.xpath("//mark[@class='data-match']//mark[@class='data-match']")).click();

} catch (Exception e) {
driver.findElement(By.xpath("//span[text()='Program']/parent::label/following-sibling::div//input[@type='text']")).click();
driver.findElement(By.xpath("//span[text()='Program']/parent::label/following-sibling::div//input[@type='text']")).clear();
driver.findElement(By.xpath("//span[text()='Program']/parent::label/following-sibling::div//input[@type='text']")).sendKeys("RxPathways");
driver.findElement(By.xpath("//mark[@class='data-match']")).click();

}

driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

                
/*              CommonMethods.PerformClickOnObject(driver.findElement(By.xpath("//span[text()='Status']/parent::span/following-sibling::div//a[@class='select']")));
List<WebElement> DropDownvalues = driver.findElements(By.xpath("//div[contains(@class,'--short visible positioned')]/div/ul/li/a")); 
CommonMethods.selectDropDownByValue(DropDownvalues, "New");*/


/*           WebElement ele = driver.findElement(By.xpath("//span[text()='Case Origin']/parent::span/following-sibling::div//a[@class='select']"));
                

                
                JavascriptExecutor js = (JavascriptExecutor) driver;
                try {
                                
                                js.executeScript("arguments[0].scrollIntoView();", ele);
                                
                                  js.executeScript("arguments[0].click();",ele);
                } catch (NullPointerException e) {
                                System.out.println("Not able to click on elem" + e);

                }

List<WebElement> DropDown1 = driver.findElements(By.xpath("//div[contains(@class,'--short visible positioned')]/div/ul/li/a"));             

List<WebElement> listbox = DropDown1;

System.out.println(listbox.size());
for (int j = 0; j < listbox.size(); j++) {
WebElement listitem = listbox.get(j);
String ObjText = listitem.getText();

if (ObjText.equals("FAX")) {
                listitem.click();
                break;
}
}*/




driver.findElement(By.xpath("//button[@title='Save']")).click();
Thread.sleep(8000);




WebElement searchPatient=driver.findElement(By.xpath("//a[@title='Search Patient']"));

JavascriptExecutor jsp = (JavascriptExecutor) driver;
try {
                
                jsp.executeScript("arguments[0].scrollIntoView();", searchPatient);
                
                  jsp.executeScript("arguments[0].click();",searchPatient);
} catch (NullPointerException e) {
                System.out.println("Not able to click on elem" + e);

}
Thread.sleep(8000);
WebElement frame=driver.findElement(By.xpath("//div[@class='slds-template__container']//iframe"));
driver.switchTo().frame(frame);
driver.findElement(By.xpath("//input[@value='Add Patient']")).click();


Random random=new Random();
for(int j=1;j<=1;j++) {
int Firstname=random.nextInt();
int LastName=random.nextInt();
driver.findElement(By.xpath("//td[text()='First Name:']/following-sibling::td//input")).sendKeys("test"+Firstname);
driver.findElement(By.xpath("//td[text()='Last Name:']/following-sibling::td//input")).sendKeys("test"+LastName);}
 
driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();

driver.findElement(By.xpath("(//input[@value='Attach Case'])[1]")).click();
driver.findElement(By.xpath("//label[text()='Enrollment Form']/preceding-sibling::input")).click();
 Thread.sleep(2000);
 driver.findElement(By.xpath("//input[@type='submit'][@value='Attach']")).click();
 
 Thread.sleep(2000);
 driver.navigate().refresh();
 driver.findElement(By.xpath("//span[text()='Supporting Documents']")).click();
                
 //driver.findElement(By.xpath("//th[@scope='row']//a")).click(); 
       
           //driver.navigate().refresh();
          // driver.findElement(By.xpath("//span[text()='Supporting Documents']")).click();
           //Thread.sleep(2000);
           
           
           /*WebElement newLink=driver.findElement(By.xpath("//a[@title='New']/parent::li"));
           JavascriptExecutor jsnewLink = (JavascriptExecutor) driver;
                                                try {
                                                                
                                                                jsnewLink.executeScript("arguments[0].scrollIntoView();", newLink);
                                                                
                                                                jsnewLink.executeScript("arguments[0].click();",newLink);
                                                } catch (NullPointerException e) {
                                                                System.out.println("Not able to click on elem" + e);*/
           
           driver.findElement(By.xpath("//a[@title='New' and @role='button']")).click();
  
           
           
           Thread.sleep(3000);
           driver.findElement(By.xpath("//span[text()='Supporting Document Name']/parent::label/following-sibling::input")).sendKeys( "SupportingDocumentName");
           
           
                  CommonMethods.PerformClickOnObject( driver.findElement(By.xpath("//span[text()='Program']/parent::label/following-sibling::div//input[@type='text']")));
                  driver.findElement(By.xpath("//span[text()='Program']/parent::label/following-sibling::div//input[@type='text']")).sendKeys("RxPathways");
                  Thread.sleep(2000);
           
                  
                  try {
                                driver.findElement(By.xpath("//mark[@class='data-match']")).click();
                         
                  } catch (Exception e1) {
                                driver.findElement(By.xpath("//span[text()='Program']/parent::label/following-sibling::div//input[@type='text']")).click();
                                driver.findElement(By.xpath("//span[text()='Program']/parent::label/following-sibling::div//input[@type='text']")).clear();
                                driver.findElement(By.xpath("//span[text()='Program']/parent::label/following-sibling::div//input[@type='text']")).sendKeys("RxPathways");
                                Thread.sleep(2000);
                                driver.findElement(By.xpath("//mark[@class='data-match']")).click();
                  }
           
                  //click on save button in Supporting Document
                  driver.findElement(By.xpath("//button[@title='Save']")).click();
                  Thread.sleep(10000);
                
                  //click on Account Icon
                   driver.findElement(By.xpath("//li[contains(@class,'overflow hideAnimation  oneConsoleTabItem')]//a/span[@title='Account']")).click();
                  Thread.sleep(3000);
                 
                  
                  //Click on Case Link
                  WebElement CaseLink= driver.findElement(By.xpath(" (//span[text()='Cases'])[2]"));
                  JavascriptExecutor link = (JavascriptExecutor) driver;
            		try {
            			link.executeScript("arguments[0].scrollIntoView();", CaseLink);
            			
            			link.executeScript("arguments[0].click();",CaseLink);
            		} catch (NullPointerException e) {
            			System.out.println("Not able to click on elem" + e);

            		} 
                  
                  
                  
                  
                  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                  
                  //Select Case ID
                  driver.findElement(By.xpath("(//span[@class='slds-grid slds-grid--align-spread']//a)[3]")).click();
                  
                  //to click on case Edit status Button
                  driver.findElement(By.xpath(" //button[@title='Edit Status']")).click();
                  
                  //to click on status textbox
                WebElement statusTextbox= driver.findElement(By.xpath("//span[text()='Status']/../following-sibling::div//a"));
                  
                  JavascriptExecutor textbox = (JavascriptExecutor) driver;
          		try {
          			textbox.executeScript("arguments[0].scrollIntoView();", statusTextbox);
          			
          			textbox.executeScript("arguments[0].click();",statusTextbox);
          		} catch (NullPointerException e) {
          			System.out.println("Not able to click on elem" + e);

          		}  
                  
          		//Select the case status from the drop down
          		List<WebElement> Casevalues = driver.findElements(By.xpath("//div[contains(@class,'--short visible positioned')]/div/ul/li/a")); 
       	        System.out.println(Casevalues.size());
        		for (int j = 0; j < Casevalues.size(); j++) {
        			WebElement listitem = Casevalues.get(j);
        			String ObjText = listitem.getText();

        			if (ObjText.equals("New")) {
        				listitem.click();
        				break;
        			}
        		}
			  //click on Save Button After changing the status as "New" 
        		driver.findElement(By.xpath("//button[@title='Save']")).click();
                 Thread.sleep(5000); 
                 
                 
                 //i need to add it in all test cases for Detach 
               //click on Detach case
                 WebElement Detachlink=driver.findElement(By.xpath("//li[@class='slds-button slds-button--neutral slds-truncate']//a[@title='Detach Case']"));
                 JavascriptExecutor Dlink = (JavascriptExecutor) driver;
           		try {
           			Dlink.executeScript("arguments[0].scrollIntoView();", Detachlink);
           			
           			Dlink.executeScript("arguments[0].click();",Detachlink);
           		} catch (NullPointerException e) {
           			System.out.println("Not able to click on elem" + e);

           		}  
                 
                 //click on Detach Button
           		WebElement PatientPageFrame=driver.findElement(By.xpath("//div[@class='slds-template_iframe slds-card iframe-parent']//iframe"));
           		driver.switchTo().frame(PatientPageFrame);
                 driver.findElement(By.xpath("//input[@value='Detach'][@type='submit']")).click();
                  
                /* //Click on Attach case
                 driver.findElement(By.xpath("//input[@value='Attach Case']")).click();
                  
                 //select value from the Type of document
                 driver.findElement(By.xpath("//label[text()='Enrollment Form']/preceding-sibling::input")).click();
                  
                 //click on Attach Button
                 driver.findElement(By.xpath("//input[@type='submit'][@value='Attach']")).click(); */
                  
                  

           
           driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                                List<WebElement> DropDowns = driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']/li[@role='presentation']"));
                                
                                for (int k =0;k<DropDowns.size();k++ ) {
                                                WebElement CloseButton = driver.findElement(By.xpath("(//button[contains(@title,'Close')])[1]"));
                                                CloseButton.click();
                                                
                                }
           
}                  

}
}
		
		




	    		
	    	
	    	
	    	
	    	
	    	
	      

	  
	  
	 
	     

	


