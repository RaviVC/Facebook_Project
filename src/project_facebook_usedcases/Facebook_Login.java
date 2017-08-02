package project_facebook_usedcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import libraries.ExcelDataConfig;
import libraries.Utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjectRepository.Facebook_LoginPage;

public class Facebook_Login extends BaseClass

{	
	
	WebDriver driver;
	Facebook_LoginPage LoginPage;
	ExtentReports report;
	ExtentTest logger;
	
	
	@BeforeTest
	public void getBrowserDetails() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver","D:\\Selenium\\FirefoxDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
	}
	
	@Test(priority=0)
	public void facebookLaunch() throws InterruptedException, Exception
	{
		/*Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/libraries/Config_Properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get(prop.getProperty("URL"));*/
		//report = new ExtentReports("C:\\Reports\\Facebook_Project.html");
		//logger = report.startTest("facebookLaunch");
		//logger.log(LogStatus.INFO, "Facebook Application is up and running");
		
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		Utility.captureScreenshot(driver, "facebooklaunch");

		Thread.sleep(2000);
		
	}
	
	@Test(priority=1)
	public void LoginFacebook() throws InterruptedException
	{	
		LoginPage = PageFactory.initElements(driver, Facebook_LoginPage.class);
		LoginPage.loginFacebook();	
		
	}
	
	@Test(priority=2)
	public void logout()
	{
		System.out.println("Logout done successfully");
	}
	
	@AfterTest
	public void tearDown()
	{
		//driver.close();
		//driver.quit();
	}
	
	@DataProvider(name="facebookdata")
	public Object[][] passData()
	{
		ExcelDataConfig config = new ExcelDataConfig("C:\\TechnicalProject\\Workpace\\Facebook_Project\\TestData\\TestDataInput.xlsx");
		int rows = config.getRowCount(0);
		
		Object[][] data = new Object[rows][2];
		
		for(int i=0;i<rows;i++)
		{
			data[i][0] = config.getData(0, i, 0);
			data[i][1] = config.getData(0, i, 1);	
		}
		
		return data;		
	}	
}
