package testRunner;

import javax.mail.MessagingException;

import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedTestNGRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import utility.Report;



@SuppressWarnings("unused")

@RunWith(ExtendedCucumber.class)


@ExtendedCucumberOptions(
jsonReport = "target/cucumber/cucumber.json",
jsonUsageReport = "target/cucumber/cucumber-usage.json",
outputFolder = "target/AdvancedReport/",
detailedReport = true,
detailedAggregatedReport = true,
overviewChartsReport = true,
overviewReport = true,
featureOverviewChart = true,
usageReport = true,
coverageReport = false,
systemInfoReport = true,
retryCount = 0,
toPDF = false,
//excludeCoverageTags = {"@flaky" },
includeCoverageTags = {""}
)



@CucumberOptions(
		
		features = {"src/test/java/pharmaTestSuite/featureFiles/Pharma"},
		glue = {"pharmaTestSuite.steps"},
		monochrome = true, 
	//	dryRun = true,
		tags = {"@jll1"},
		snippets = SnippetType.UNDERSCORE,//SnippetType.CAMELCASE,
		strict = true,
		
		plugin = {"pretty:target/cucumber/pretty.txt",
				"html:target/cucumber",
				"json:target/cucumber/cucumber.json",
				"usage:target/cucumber/cucumber-usage.json",
				"junit:target/XML/Cucumber.xml",
				"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:"}
		)

	
@Listeners(utility.ListnerTestNG.class)

public class Pharma_PfizerRunner extends ExtendedTestNGRunner{	
	
@org.testng.annotations.AfterClass()
	
	public static void teardown1() throws MessagingException {
	
	Report.extentEnvironmentInfo();  
	
}


	

}
