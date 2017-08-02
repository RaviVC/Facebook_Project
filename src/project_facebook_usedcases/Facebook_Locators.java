package project_facebook_usedcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Facebook_Locators {
	
	@Test
	public void locators() throws Exception
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("ravidevale28@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("saniamirza");
		driver.findElement(By.linkText("Forgotten account?")).click();
		driver.findElement(By.partialLinkText("Create")).click();
		driver.findElement(By.className("inputtext")).sendKeys("ramyap23@gmail.com");
		
	}

}
