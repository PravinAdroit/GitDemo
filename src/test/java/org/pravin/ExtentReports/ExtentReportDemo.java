package org.pravin.ExtentReports;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {

	ExtentReports extent;
	
	@BeforeTest
	
	public void config()
	{
		/*
		 * so when we are dealing with ExtentReport we need to remember two classes 
		 * 1. ExtentReports and 2. ExtentSparkReporter
		 * So creating the object as "reporter" for ExtentSparkReporter class which needs a path where your report should be created
		 * so storing the path of the file in string variable
		 * so this ExtentSparksReporte chreate one reports folder with index.html file in the project -- which having a test result
		 */
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Extent Reports");
		
		/*
		 * so this reporter object is responsible for the all configuration related to the reports
		 * like report name and Document Title etc
		 */
	
		/*
		 * ExtentReports - this main class is responsible for drive all your reporting executions 
		 * so first we need to attach the "reports" with "extent"
		 * because this "extent" is responsible to create and consolidate all your test execution.
		 * "ExtentSparkReporter" is helper class which helping to create some configuration and that finally reports to "ExtentReport" class
		 */
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Pravin Parab");
			/*
			 * so you attaching the extent with reporter with all configuration
			 * extent helps to set tester name with set system info
			 */
			
			/*
			 * now creating a connection between the testcase with ExtentReports so declare ExtentReports with reporter variable at global level
			 * so with create test this extent monitoring the test case if the test case is pass it will go back and mark it as pass in index.html file
			 * extent.flush; is indicate that there is no more for monitoring now the test is done
			 * so when you createTest then Automatically one object get created lets catch that object
			 */
			
			
	}
	
	
	@Test
	
	public void initialDemo() throws InterruptedException
	{
		ExtentTest test = extent.createTest("Initial Demo");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver  = new ChromeDriver();
		driver.get("https://mvnrepository.com/");
		System.out.println(driver.getTitle()); 	
		Thread.sleep(3000);
		driver.close();
		//test.fail("Results Do Not match");
		extent.flush();
	
	}
	
}
