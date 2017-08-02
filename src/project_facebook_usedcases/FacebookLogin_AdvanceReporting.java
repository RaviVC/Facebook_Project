package project_facebook_usedcases;

import java.util.concurrent.TimeUnit;

import libraries.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.internal.annotations.ITest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FacebookLogin_AdvanceReporting {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@Test 
	public void facebookLaunch() throws InterruptedException
	{
		report = new ExtentReports("C:\\Reports\\FacebookAutomation\\Facebooklaunch.html");
		logger = report.startTest("facebookLaunch");
		
		System.setProperty("webdriver.gecko.driver","D:\\Selenium\\FirefoxDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		logger.log(LogStatus.INFO, "Browserstarted");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		logger.log(LogStatus.INFO, "Facebook Application launched");
		String title = driver.getTitle();
		Assert.assertTrue(title.contains("Facebook"));
		logger.log(LogStatus.PASS, "Title verified");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE);
		{
			String screenshotpath = Utility.captureScreenshot(driver,result.getName());
			String image = logger.addScreenCapture(screenshotpath);
			logger.log(LogStatus.FAIL, "Title verification", image);
		}
		report.endTest(logger);
		report.flush();
		
		driver.get("C:\\Reports\\FacebookAutomation\\Facebooklaunch.html");
	}

}
