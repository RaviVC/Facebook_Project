package project_facebook_usedcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
	
	WebDriver driver; 
	
	@BeforeTest
	public void browserSetup()
	{
		Reporter.log("=====Browser session started =====");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);	
	}
	
	@AfterMethod
	public void closeApplication()
	{
		driver.quit();
		Reporter.log("=====Browser session closed =====");
	}
	

}

