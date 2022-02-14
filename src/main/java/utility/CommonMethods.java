package utility;

import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.sun.mail.util.MailConnectException;
import com.vimalselvam.cucumber.listener.Reporter;

import objectRepository.GetObj;
import pharmaTestSuite.steps.stepsPharma.PfizerTestCaseID;
import DataReaders.*;

@SuppressWarnings("unused")
public class CommonMethods extends GetObj   {




	GetObj loginPfizer;
	WebDriverFactory webDriverFactory;
	public static WebDriver driver;
	boolean present;
	public String Portal_PatientID=null;
	String TestCaseID = PfizerTestCaseID.TCID;
	String ModuleName = PfizerTestCaseID.SheetName;


	@SuppressWarnings("static-access")
	public CommonMethods(WebDriverFactory DriverFactory) throws Exception
	{
		super(DriverFactory);
		webDriverFactory = DriverFactory;
		this.driver = webDriverFactory.getWebDriver();

	}





	public static void closeBrowser(WebDriver driver) throws Throwable {

		Runtime rt = Runtime.getRuntime();
		int s = rt.availableProcessors();
		Thread.sleep(5000);
		driver.close();
		driver.quit();

	}

	public static void closeWebDriverProcess() throws Exception {

		switch (ConfigFile.getConfigValue("Browser").toString()) {

		case "chrome":

			System.out.println("In closeWebDriverProcess");
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");

			break;

		default:
			throw new IllegalAccessException();

		}
		Thread.sleep(5000);

	}

	public static void selectFromDropDownByVisibleText(WebElement ListObj, String Value) {

		try {
			Select SelectDrop = new Select(ListObj);
			Thread.sleep(2000);
			SelectDrop.selectByVisibleText(Value);
		} catch (Exception e) {
			System.out.println("Did not select any value" + e);
		}

	}

	/*	public static void selectFromDropDownByValue(WebElement selectList, String b) {

		try {
			Select Value = new Select(selectList);
			Value.selectByValue(b);
		} catch (Exception e) {
			System.out.println("Did not select any value");
		}

	}*/


	public static void CopyLogsInArchive()   {
		String FilePath = "C:\\TestAutomation1\\CucumberFramework\\target\\ExetentReport";
		String ArchiveFolderPath = "C:\\TestAutomation1\\CucumberFramework\\target\\ExetentReport\\Archive";

		File dir = new File(FilePath);
		String[] files = dir.list();


		for (String aFile : files) {
			System.out.println(aFile);
			if (aFile.contains(".html")) {
				try {
					Path temp = Files.move
							(Paths.get(FilePath+"\\"+aFile),  
									Paths.get(ArchiveFolderPath+"\\"+aFile));
				} catch (IOException e) {
					System.out.println("Not able to move Results file in Archive = "+e);
					e.printStackTrace();
				}     
			}
		}
	}



	public static  void  ScrolDownToTheObject(WebElement Element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].scrollIntoView();", Element);
		} catch (NullPointerException e) {
			System.out.println("Object is Not able Scrol" + e);

		}

	} 


	public static  void PerformClickOnObject(WebElement Element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].scrollIntoView();", Element);

			js.executeScript("arguments[0].click();",Element);
		} catch (NullPointerException e) {
			System.out.println("Not able to click on elem" + e);

		}
	} 

	public static void selectDropDownByValue(List<WebElement> ListBoxObj, String Value) throws Throwable {

		List<WebElement> listbox = ListBoxObj;

		System.out.println(listbox.size());
		for (int j = 0; j < listbox.size(); j++) {
			WebElement listitem = listbox.get(j);
			String ObjText = listitem.getText();

			if (ObjText.equals(Value)) {
				listitem.click();
				break;
			}
		}
	}



	public static void VerifyDropDownValues(List<WebElement> ListBoxObj, String Values) throws Throwable {

		List<WebElement> listbox = ListBoxObj;

		System.out.println(listbox.size());

		for (int j = 0; j < listbox.size(); j++) {
			WebElement listitem = listbox.get(j);
			String ObjText = listitem.getText();

			if (ObjText.equals(Values)) {				
				Assert.assertTrue(listitem.isDisplayed());
			}
			else {
				Assert.assertTrue(listitem.isDisplayed());
			}

		}
	}





	public static void AuthorsName()  {

		String ComputerName = System.getenv("COMPUTERNAME");

		if(ComputerName.contains("52027063")) {
			ComputerName ="Aniket_Patil";
		}
		else if(ComputerName.contains("52027059")) {
			ComputerName ="Ashirbad_Prusty";
		}
		else if(ComputerName.contains("52026740")) {
			ComputerName ="Sayyed_Safwan";
		}
		else if(ComputerName.contains("52006886")) {
			ComputerName ="Sushmitha_LNU ";
		}
		else {
			ComputerName = System.getenv("COMPUTERNAME");
		}

		Reporter.assignAuthor(ComputerName);
	}



	public static void SwitichingFrames(WebElement element) {
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		for (int i =0;i<=size;++i ) {

			try {
				driver.switchTo().defaultContent();
				System.out.println("start" + i);
				driver.switchTo().frame(i);
				System.out.println("Enter inn frame " + i);
				WebElement  ele1 = element;

				break;
			} catch (NoSuchElementException | NoSuchFrameException e) {
				System.out.println("InCatch  "+i);
			}


		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}


	public static void VerifyDropDownValuesBySelectClass(WebElement ListBoxObj, String Values) throws Throwable {


		Select select = new Select(ListBoxObj); 
		java.util.List<WebElement> options1 = select.getOptions(); 
		Boolean found = false;
		for(WebElement item:options1) 
		{ 
			if (item.getText().equals(Values)) {
				found = true;
				break;
			}else {
				found = false;
			}
		}

		if (found) {
			System.out.println(Values+" is displayed");
			Assert.assertTrue(found==true);
		}else {
			System.out.println(Values+" is not displayed");
			Assert.assertTrue(found==true);
		}

	}



	public static String getAlertText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			return alertText;
		} catch (NoAlertPresentException e) {
			throw new NoAlertPresentException();
		}
	}



	public static boolean isAlertPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			throw new NoAlertPresentException();
		}
	}



	public static void acceptAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}

	public static void CaseCreation(int n) throws InterruptedException {
		String exePath = System.getProperty("user.dir")+"\\src\\test\\resources\\WebDrivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Users/Manjunath.Dinesh/AppData/Local/Google/Chrome/User Data/Profile 1");
		options.addArguments("--start-maximized");


		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);



		String url ="https://pfizerpas--pfizerqa.lightning.force.com/lightning/r/Application__c/a010t000005yiQGAAY/view"
				;                                              

		driver.get(url);
		driver.findElement(By.id("username")).sendKeys("aniket.patil@conduent.com.pfizerqa");
		driver.findElement(By.id("password")).sendKeys("Mar@1234");

		driver.findElement(By.id("Login")).click();

		try {        
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[text()='Remind Me Later']")).click();
			driver.navigate().refresh();
			Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),' Sandbox:')]")).isDisplayed());
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Logged In Succesfully");             
		}catch (NoSuchElementException   Ex ) {
			try {
				Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),' Sandbox:')]")).isDisplayed());
				driver.navigate().refresh();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println("Logged In Succesfully");                   
			}catch (UnhandledAlertException e) {
				driver.switchTo().alert().accept();
			} catch (NoSuchElementException e) {
				System.out.println("Enter The OTP");
				String OTPtoEnter = EmailUtility.GetOTP("vinutha.kj@conduent.com","Pvc345678&");
				driver.findElement(By.xpath("//label[text()='Verification Code']/following-sibling::div/input[@type='text']")).sendKeys(OTPtoEnter);
				driver.findElement(By.xpath("//input[@value='Verify']")).click();
				driver.navigate().refresh();   
			}


		}catch (UnhandledAlertException e) {
			driver.switchTo().alert().accept();            
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> DropDown = driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']/li[@role='presentation']"));

		for (int i =0;i<DropDown.size();i++ ) {
			WebElement CloseButton = driver.findElement(By.xpath("(//button[contains(@title,'Close')])[1]"));
			CloseButton.click();

		}

		driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();

		driver.findElement(By.xpath("//a[@title='Cases']")).click();
		try {

			driver.findElement(By.xpath("//button[@title='Display as Table']"));
			System.out.println("Opened in Split View");
			Thread.sleep(3000);

		} catch (NoSuchElementException e) {
			System.out.println("Opened in Table View");

			driver.findElement(By.xpath("//button[@title='Display as Split View']")).click();

			System.out.println("It will oven in Table View");

			driver.findElement(By.xpath("//ul[@class='dropdown__list']//li[@title='Table']")).click();
			Thread.sleep(5000);

		}
		driver.findElement(By.xpath("//a[@title='Select List View']")).click();
		driver.findElement(By.xpath("(//span[text()='Document Intake']/parent::a)[1]")).click();
		Thread.sleep(3000);



		for(int i=1;i<=n;i++) {




			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='New' and @role='button']")).click();
			Thread.sleep(3000);
			WebElement ele2 =driver.findElement(By.xpath ("//span[text()='Inbound Fax']"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,1000)", "");


			JavascriptExecutor jss = (JavascriptExecutor) driver;
			try {

				jss.executeScript("arguments[0].scrollIntoView();", ele2);

				jss.executeScript("arguments[0].click();",ele2);
			} catch (NullPointerException e) {
				System.out.println("Not able to click on elem" + e);

			}


			driver.findElement(By.xpath ("//span[text()='Inbound Fax']")).click();


			driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
			Thread.sleep(3000);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
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


			WebElement ele = driver.findElement(By.xpath("//span[text()='Case Origin']/parent::span/following-sibling::div//a[@class='select']"));



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
			}

			driver.findElement(By.xpath("//button[@title='Save']")).click();
			Thread.sleep(8000);	
			WebElement CaseID=driver.findElement(By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow  is-read-only'])[1]/span"));

			String CaseIDvalue=CaseID.getText();
			System.out.println(CaseIDvalue);
			String filepath="C:\\TestAutomation\\CucumberFramework\\src\\test\\resources\\TestData\\CaseIDs.txt";
			BufferedWriter bw = null;
			FileWriter fw = null;

			try {

				//creating a file
				File file = new File(filepath);

				// if file doesnt exists, then create it
				if (!file.exists()) {
					file.createNewFile();
				}

				// true = append file
				fw = new FileWriter(file.getAbsoluteFile(),true);
				bw = new BufferedWriter(fw);

				bw.write(CaseIDvalue+" ");


				System.out.println("Done");

			} catch (Exception e) {

				e.printStackTrace();

			} finally {

				try {

					if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();

				} catch (Exception ex) {

					ex.printStackTrace();

				}
			}





			Thread.sleep(2000);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			List<WebElement> DropDowns = driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']/li[@role='presentation']"));

			for (int k =0;k<DropDowns.size();k++ ) {
				WebElement CloseButton = driver.findElement(By.xpath("(//button[contains(@title,'Close')])[1]"));
				CloseButton.click(); }    }  
		Thread.sleep(3000);

		//click on Filter Button             
		driver.findElement(By.xpath("//lightning-button-icon-stateful[@class='listViewManagerHeaderButton filterButton']//button[@title='Show filters']")).click();

		//click on Remove all button
		driver.findElement(By.xpath("//a[@class='removeAll'][text()='Remove All']")).click();	

		//click on Filter save Button
		driver.findElement(By.xpath("//div//button[text()='Save']")).click(); 

		//click on Add filter
		driver.findElement(By.xpath("//a[text()='Add Filter']")).click();

		//click on Account ID Field
		driver.findElement(By.xpath("(//div//input[@placeholder='Select an Option'])[1]")).click();

		//select value from Field dropdown
		Thread.sleep(3000);
		By option = By.xpath("//*[@data-value='Status']");
		driver.findElement(option).click();
		Thread.sleep(5000);	 

		//click on value field 
		driver.findElement(By.xpath("//div[@class='valueInput uiMenu forceFilterPanelMultiPicklistCriterionEditor']")).click(); 

		//select the value from value field dropdown

		List<WebElement> DropDownvalues = driver.findElements(By.xpath("//div[@class='forceFilterPanelMultiPicklistCriterionEditor']/ul/li/a"));             
		List<WebElement> values = DropDownvalues;
		System.out.println(values.size());
		for (int j = 0; j < values.size(); j++) {
			WebElement listitemvalues = values.get(j);
			String ObjText = listitemvalues.getText();

			if (ObjText.equals("New")) {
				listitemvalues.click();
				break;
			}						}
		//click on Done Button
		driver.findElement(By.xpath("//button//span[text()='Done']")).click();



		//click on 2nAdd filter
		driver.findElement(By.xpath("//a[text()='Add Filter']")).click();

		//click on Account ID Field
		driver.findElement(By.xpath("(//div//input[@placeholder='Select an Option'])[1]")).click();

		//select value from Field dropdown
		Thread.sleep(3000);
		By optionTwo = By.xpath("//*[@data-value='Origin']");
		driver.findElement(optionTwo).click();
		Thread.sleep(5000);	 

		//click on value field 
		driver.findElement(By.xpath("//div[@class='valueInput uiMenu forceFilterPanelMultiPicklistCriterionEditor']")).click(); 

		//select the value from value field dropdown

		List<WebElement> CaseDropDownvalues = driver.findElements(By.xpath("//div[@class='forceFilterPanelMultiPicklistCriterionEditor']/ul/li/a"));             
		List<WebElement> casevalues = CaseDropDownvalues;
		System.out.println(casevalues.size());
		for (int j = 0; j < casevalues.size(); j++) {
			WebElement listitemvalues1 = casevalues.get(j);
			String ObjText = listitemvalues1.getText();

			if (ObjText.equals("FAX")) {
				listitemvalues1.click();
				Thread.sleep(1000);
				break;
			}						}
		//click on Done Button
		driver.findElement(By.xpath("//button//span[text()='Done']")).click();

		//click on 3rAdd filter
		driver.findElement(By.xpath("//a[text()='Add Filter']")).click();

		//click on Account ID Field
		driver.findElement(By.xpath("(//div//input[@placeholder='Select an Option'])[1]")).click();

		//select value from Field dropdown
		Thread.sleep(3000);
		By option3 = By.xpath("//*[@data-value='Client__r.Name']");
		driver.findElement(option3).click();
		Thread.sleep(5000);	 

		//write the value In value field
		driver.findElement(By.xpath("//input[@class='filterTextInput valueInput input uiInput uiInputText uiInput--default uiInput--input']")).sendKeys("Pfizer");
		//click on Done Button
		driver.findElement(By.xpath("//button//span[text()='Done']")).click();

		//click on 4th Add filter
		driver.findElement(By.xpath("//a[text()='Add Filter']")).click();

		//click on Account ID Field
		driver.findElement(By.xpath("(//div//input[@placeholder='Select an Option'])[1]")).click();

		//select value from Field dropdown
		Thread.sleep(3000);
		By option4 = By.xpath("//*[@data-value='Program__r.Name']");
		driver.findElement(option4).click();
		Thread.sleep(5000);	 


		//write the value In value field
		driver.findElement(By.xpath("//input[@class='filterTextInput valueInput input uiInput uiInputText uiInput--default uiInput--input']")).sendKeys("RxPathways");
		//click on Done Button
		driver.findElement(By.xpath("//button//span[text()='Done']")).click();

		//click on Filter save Button
		driver.findElement(By.xpath("//div//button[text()='Save']")).click(); 
	} 


	public static void CreatePatients(int n) throws Throwable {

		CommonMethods.closeWebDriverProcess();
		for(int k=1;k<=n;k++) {
			try {


				String exePath = System.getProperty("user.dir")+"\\src\\test\\resources\\WebDrivers\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", exePath);

				ChromeOptions options = new ChromeOptions();



				Map<String,Object> pref = new HashMap<String, Object>();
				pref.put("profile.exit_type", "none");
				pref.put("profile.exited_cleanly", Boolean.valueOf("True"));
				options.setExperimentalOption("prefs", pref);
				options.addArguments("--disable-notifications");
				options.addArguments("disable-infobars");
				options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
				options.setCapability("exit_type", "none");				
				options.addArguments("user-data-dir=C:/Users/52026740/AppData/Local/Google/Chrome/User Data/Default");

				WebDriver driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);




				String url ="https://test.salesforce.com/";                                              

				driver.get(url);
				//login as Admin
				driver.findElement(By.id("username")).sendKeys("sayyed.safwan2@conduent.com.pfizer.pfzuatnew");
				driver.findElement(By.id("password")).sendKeys("Aug@12345");
				driver.findElement(By.id("Login")).click();


				try {        
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					driver.findElement(By.xpath("//a[text()='Remind Me Later']")).click();
					driver.navigate().refresh();
					Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),' Sandbox:')]")).isDisplayed());
					driver.navigate().refresh();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					System.out.println("Logged In Succesfully");             
				}catch (NoSuchElementException   Ex ) {
					try {
						Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),' Sandbox:')]")).isDisplayed());
						driver.navigate().refresh();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						System.out.println("Logged In Succesfully");                   
					}catch (UnhandledAlertException e) {
						driver.switchTo().alert().accept();
					} catch (NoSuchElementException e) {
						System.out.println("Enter The OTP");
						String OTPtoEnter = EmailUtility.GetOTP("vinutha.kj@conduent.com","Pvc345678&");
						driver.findElement(By.xpath("//label[text()='Verification Code']/following-sibling::div/input[@type='text']")).sendKeys(OTPtoEnter);
						driver.findElement(By.xpath("//input[@value='Verify']")).click();
						driver.navigate().refresh();   
					}


				}catch (UnhandledAlertException e) {
					driver.switchTo().alert().accept();            
				}







				driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
				driver.switchTo().defaultContent();
				List<WebElement> DropDown = driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']/li[@role='presentation']"));
				System.out.println("No Of Tabs Open: "+DropDown.size());
				for (int i =0;i<DropDown.size();i++ ) {
					WebElement CloseButton = driver.findElement(By.xpath("(//button[contains(@title,'Close')])[1]"));
					CloseButton.click();

				}
				Thread.sleep(5000);


				System.out.println("Click on navihation");
				driver.findElement(By.xpath("//button[@title='Show Navigation Menu']")).click();
				System.out.println("Clicked on navihation");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//a//span[text()='Accounts']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//a[@title='New' and @role='button']")).click();
				Thread.sleep(3000);
				//select Patient-Pfizer radio Button
				driver.findElement(By.xpath("(//label[@class='uiLabel-left form-element__label uiLabel'])[3]/span[text()='Pfizer Patient']")).click();
				//click on Next Button
				driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral slds-button slds-button--brand']")).click();
				WebElement frame=driver.findElement(By.xpath("//div[@class='slds-template_iframe slds-card iframe-parent']//iframe"));
				driver.switchTo().frame(frame);
				Random random=new Random();
				for(int j=1;j<=1;j++) {
					int Firstname=random.nextInt();
					int LastName=random.nextInt();
					driver.findElement(By.xpath("//td[text()='First Name:']/following-sibling::td//input")).sendKeys("test"+Firstname);
					driver.findElement(By.xpath("//td[text()='Last Name:']/following-sibling::td//input")).sendKeys("test"+LastName);
				}
				driver.findElement(By.xpath("//td[text()=' Date of Birth:']/following-sibling::td//input")).sendKeys("07/07/1994");
				driver.findElement(By.xpath("(//td[text()='Street Address:']/following-sibling::td/img)[1]")).click();
				//enter address in New Window
				String winHandleBefore = driver.getWindowHandle();

				for(String winHandle : driver.getWindowHandles()){
					driver.switchTo().window(winHandle);
				}
				driver.manage().window().maximize() ;
				
				

				driver.findElement(By.xpath("//td[text()='Verify Manually:']/following-sibling::td/input")).click();
				//driver.findElement(By.xpath("//td[text()='Street 1:']/following-sibling::td/input")).sendKeys("500 Atrium Dr");
				
				driver.findElement(By.xpath("//td[text()='City:']/following-sibling::td/input")).sendKeys("Somerset");
				driver.findElement(By.xpath("//td[text()='State:']/following-sibling::td/input")).sendKeys("NJ");
				driver.findElement(By.xpath("//td[text()='Zip:']/following-sibling::td/input")).sendKeys("08873-4161");
				driver.findElement(By.xpath("//td[text()='Street 1:']/following-sibling::td/input")).sendKeys("500 Atrium Dr");
				Thread.sleep(2000);
//				driver.findElement(By.xpath("//span[@class='smarty-tag-check']")).click();
//				driver.findElement(By.xpath("//span[@class='smarty-tag-check']")).click();
//				driver.findElement(By.xpath("//span[@class='smarty-tag-check']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//input[@value='save']")).click();
				driver.switchTo().window(winHandleBefore);
				driver.switchTo().frame(0); 
				Thread.sleep(5000);
				driver.findElement(By.xpath("//td[text()='Check if Shipping Address is same as Mailing Address']/parent::tr/td/input[@type='checkbox']")).click();
				driver.findElement(By.xpath("//td[text()=' Home Phone:']/following-sibling::td/input[contains(@id,'personPhone')]")).sendKeys("7349085599");
				driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();

				


				//adding supporting document
				Thread.sleep(5000);
				driver.findElement(By.xpath("//span[text()='Supporting Documents']")).click();
				driver.findElement(By.xpath("(//a[@title='New' and @role='button'])[2]")).click();

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
					Thread.sleep(2000);
				}

				//click on save button in Supporting Document
				driver.findElement(By.xpath("//button[@title='Save']")).click();
				Thread.sleep(8000);

				//click on Account link
				driver.findElement(By.xpath("(//span[text()='Account'])[3]/../following-sibling::div//a")).click();
				Thread.sleep(3000);
				WebElement PatientID=driver.findElement(By.xpath("(//span[@class='test-id__field-value slds-form-element__static slds-grow  is-read-only'])[3]/span"));

				String PatientIDvalue=PatientID.getText();
				System.out.println(PatientIDvalue);
				String filepath="C:\\TestAutomation1\\CucumberFramework\\src\\test\\resources\\TestData\\PatientIDs.txt";
				BufferedWriter bw = null;
				FileWriter fw = null;

				try {

					//creating a file
					File file = new File(filepath);

					// if file doesnt exists, then create it
					if (!file.exists()) {
						file.createNewFile();
					}

					fw = new FileWriter(file.getAbsoluteFile(),true);
					bw = new BufferedWriter(fw);

					bw.write(PatientIDvalue+" ");



				} catch (Exception e) {

					e.printStackTrace();

				} finally {

					try {

						if (bw != null)
							bw.close();

						if (fw != null)
							fw.close();

					} catch (Exception ex) {

						ex.printStackTrace();

					}
				}


				driver.switchTo().defaultContent();

				Thread.sleep(8000);
				List<WebElement> DropDowns = driver.findElements(By.xpath("//ul[@class='tabBarItems slds-grid']/li[@role='presentation']"));
				for (int m =0;m<DropDowns.size();m++ ) {
					WebElement CloseButton = driver.findElement(By.xpath("(//button[contains(@title,'Close')])[1]"));
					CloseButton.click(); 
				} 

				Thread.sleep(5000); 




				driver.findElement(By.xpath("//img[@alt='User']/parent::span")).click();
				Thread.sleep(1000);	
				driver.findElement(By.xpath("//a[text()='Settings']/following-sibling::a[text()='Log Out']")).click();
				//System.out.println("Logged Out From Pfizer");

				Thread.sleep(5000); 
			CommonMethods.closeWebDriverProcess();	  

			}catch(Exception e) {
				CommonMethods.closeWebDriverProcess();	  
			}

		}


	}











}




