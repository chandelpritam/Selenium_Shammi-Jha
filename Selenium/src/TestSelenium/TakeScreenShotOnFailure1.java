package TestSelenium;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class TakeScreenShotOnFailure1 {
	WebDriver driver;

	public void captureScreenShot(ITestResult result) throws Exception {
		if (ITestResult.FAILURE == result.getStatus()) {

			// Creating referance of TakesScreenShot Interface and Type Casting
			TakesScreenshot ts = (TakesScreenshot) driver;

			// Call method to capture screenshot in terms of File
			File source = ts.getScreenshotAs(OutputType.FILE);

			// Copy files to specific location
			FileUtils.copyFile(source, new File("./Screenshots/" + result.getName() + ".png"));
			System.out.println("Screenshot Captured");
		}
	}

}
