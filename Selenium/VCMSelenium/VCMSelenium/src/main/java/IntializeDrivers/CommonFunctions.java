package IntializeDrivers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonFunctions {
	
	 public static void scrolltocentre(WebElement ele , WebDriver driver) {
		  
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({\r\n" + 
		  		"          behavior: 'auto',\r\n" + 
		  		"          block: 'center',\r\n" + 
		  		"          inline: 'center'\r\n" + 
		  		"      });", ele);
	  }
		  

	 public static void highlight(WebElement ele , WebDriver driver) {
			
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
         executor.executeScript("arguments[0].setAttribute('style', 'background: orange; border: 2px solid red;');", ele);
		  
	  }
	 
		public static void javascriptclick(WebElement element , WebDriver driver) {
			   JavascriptExecutor executor = (JavascriptExecutor)driver;
			   executor.executeScript("arguments[0].click();", element);}
		
		public static String failedscreenshot(WebDriver driver, String Screenshotname) throws IOException
		{
			String datename = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
			TakesScreenshot ts =(TakesScreenshot)driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			String dest =BrowserData.getFailedtestcasesPath()+Screenshotname+datename+".png";
			File destloc= new File(dest);
			FileUtils.copyFile(Source, destloc);
			return dest;
			
		}
				
	 
}
