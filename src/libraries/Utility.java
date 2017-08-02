package libraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class Utility {
	
	public static String captureScreenshot(WebDriver driver, String Screenshotname)
	{
		
		try {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String dest = "./Screenshots"+Screenshotname+".png";
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			System.out.println("Screenshot taken");
			
		
		}  catch (Exception e) {
		   e.printStackTrace();
		   System.out.println("Exception while taking screenshot"+e.getMessage());
		}
		return Screenshotname;
		
	}

}
