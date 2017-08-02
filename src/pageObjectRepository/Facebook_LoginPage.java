package pageObjectRepository;

import libraries.ExcelDataConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Facebook_LoginPage {
	
	WebDriver driver;
	
	public Facebook_LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(linkText="Forgotten account?")
	WebElement ForgottenAccountLink;
	
	public void loginFacebook() throws InterruptedException
	{
		ExcelDataConfig edc = new ExcelDataConfig("C:\\TechnicalProject\\Workpace\\Facebook_Project\\TestData\\TestDataInput.xlsx");
		String FBUsername = edc.getData(0, 0, 0);
		username.sendKeys(FBUsername);
		Thread.sleep(2000);
		
		String FBPassword = edc.getData(0, 0, 1);
		password.sendKeys(FBPassword);
		Thread.sleep(2000);
		
		loginbutton.click();
		Thread.sleep(5000);
	}

}
