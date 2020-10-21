package TestSelenium;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TakeScreenShotOnFailure2 {

	TakeScreenShotOnFailure1 t1 = new TakeScreenShotOnFailure1();

	@Test(priority = 1)
	public void doLogin() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Library\\Driver\\chromedriver.exe");
		t1.driver = new ChromeDriver();
		t1.driver.manage().window().maximize();
		t1.driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		t1.driver.get("https://www.facebook.com/");

		t1.driver.findElement(By.xpath("*//[@id='email']")).sendKeys("abc@gmail.com");
		t1.driver.findElement(By.xpath("*//[@id='pass']")).sendKeys("12345");

		// Pass Wrong ID so that it will fall our test case
		t1.driver.findElement(By.xpath("//*[@id='login_Button_Pritam']")).click();
	}

	@Test(priority = 2)
	public void assertionCheck() {
		String actual = "abc";
		String expected = "abc";
		assertEquals(actual, expected);
	}

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult result) throws Exception {
		t1.captureScreenShot(result);
		t1.driver.quit();
	}

}
